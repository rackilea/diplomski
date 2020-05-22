public class TestFretBoard {

    public static void main(String[] args) {
        new TestFretBoard();
    }

    public TestFretBoard() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new ChordsPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ChordsPane extends JPanel {

        public ChordsPane() {
            setLayout(new BorderLayout());
            FretPane fretPane = new FretPane();
            fretPane.setChord(new AChord());
            add(fretPane);
        }
    }

    public static interface FretBoard {

        public Rectangle getFretBounds(int index);

        public GuitarString getGuitarString(int index);

        public GuitarString[] getGuitarStrings(int... index);
    }

    public static class FretPane extends JPanel implements FretBoard {

        private static final Point BOARD_OFFSET = new Point(9, 9);
        private static final int BOARD_WIDTH = 84;
        private static final Rectangle[] FRET_BOUNDS = {
            new Rectangle(BOARD_OFFSET.x, 20, BOARD_WIDTH, 68 - 20),
            new Rectangle(BOARD_OFFSET.x, 71, BOARD_WIDTH, 113 - 71),
            new Rectangle(BOARD_OFFSET.x, 116, BOARD_WIDTH, 153 - 116),
            new Rectangle(BOARD_OFFSET.x, 156, BOARD_WIDTH, 189 - 156),
            new Rectangle(BOARD_OFFSET.x, 192, BOARD_WIDTH, 222 - 192),
            new Rectangle(BOARD_OFFSET.x, 225, BOARD_WIDTH, 254 - 225),
            new Rectangle(BOARD_OFFSET.x, 257, BOARD_WIDTH, 289 - 257),
            new Rectangle(BOARD_OFFSET.x, 287, BOARD_WIDTH, 312 - 287),
            new Rectangle(BOARD_OFFSET.x, 315, BOARD_WIDTH, 338 - 315),
            new Rectangle(BOARD_OFFSET.x, 341, BOARD_WIDTH, 364 - 341),
            new Rectangle(BOARD_OFFSET.x, 367, BOARD_WIDTH, 389 - 367),
            new Rectangle(BOARD_OFFSET.x, 392, BOARD_WIDTH, 412 - 392),};
        private static final GuitarString[] GUITAR_STRINGS = {
            new GuitarString(85 - BOARD_OFFSET.x, 1),
            new GuitarString(72 - BOARD_OFFSET.x, 1),
            new GuitarString(58 - BOARD_OFFSET.x, 1),
            new GuitarString(43 - BOARD_OFFSET.x, 2),
            new GuitarString(29 - BOARD_OFFSET.x, 2),
            new GuitarString(15 - BOARD_OFFSET.x, 2),};
        private BufferedImage background;
        private Chord chord;

        public FretPane() {
            try {
                background = ImageIO.read(new File("fretboard02.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return background == null ? super.getPreferredSize() : new Dimension(background.getWidth(), background.getHeight());
        }

        public Chord getChord() {
            return chord;
        }

        public void setChord(Chord chord) {
            this.chord = chord;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            if (background != null) {
                int x = (getWidth() - background.getWidth()) / 2;
                int y = (getHeight() - background.getHeight()) / 2;
                g2d.drawImage(background, x, y, this);
                Chord chord = getChord();
                if (chord != null) {
                    g2d.translate(x, y);
                    chord.paint(this, g2d);
                    g2d.translate(-x, -y);
                }
            }
            g2d.dispose();
        }

        @Override
        public Rectangle getFretBounds(int index) {
            Rectangle bounds = null;
            if (index >= 0 && index < FRET_BOUNDS.length) {
                bounds = FRET_BOUNDS[index];
            }
            return bounds;
        }

        @Override
        public GuitarString getGuitarString(int index) {
            GuitarString gs = null;
            if (index >= 0 && index < GUITAR_STRINGS.length) {
                gs = GUITAR_STRINGS[index];
            }
            return gs;
        }

        @Override
        public GuitarString[] getGuitarStrings(int... indices) {
            List<GuitarString> strings = new ArrayList<GuitarString>(indices.length);
            for (int index : indices) {
                strings.add(getGuitarString(index));
            }
            return strings.toArray(new GuitarString[strings.size()]);
        }
    }

    public static class GuitarString {

        private int x;
        private int width;

        public GuitarString(int x, int width) {
            this.x = x;
            this.width = width;
        }

        public int getX() {
            return x;
        }

        public int getWidth() {
            return width;
        }
    }

    public interface Chord {

        public String getName();

        public void paint(FretBoard board, Graphics2D g2d);
    }

    public abstract class AbstractChord implements Chord {

        public abstract int[] getFrets();

        public abstract GuitarString[] getGuitarStrings(FretBoard board, int fret);

        @Override
        public void paint(FretBoard board, Graphics2D g2d) {
            for (int fret : getFrets()) {
                Rectangle fretBounds = board.getFretBounds(fret);
                // Guitar Strings start at 5 (thickest) to 0 (smallest)
                GuitarString[] guitarStrings = getGuitarStrings(board, fret);

                int y = fretBounds.y + (fretBounds.height / 2);

                g2d.setColor(Color.RED);
                Ellipse2D dot = new Ellipse2D.Float(0, 0, 10, 10);

                for (GuitarString gs : guitarStrings) {
                    int x = ((gs.x + fretBounds.x) + (gs.width / 2)) - 5;
                    g2d.fill(getDot(dot, x, y - 5));
                }
            }
        }

        public Shape getDot(Ellipse2D dot, int x, int y) {

            PathIterator pathIterator = dot.getPathIterator(AffineTransform.getTranslateInstance(x, y));
            Path2D path = new Path2D.Float();
            path.append(pathIterator, true);

            return path;

        }
    }

    public class AChord extends AbstractChord {

        private int index;

        @Override
        public String getName() {
            return "A";
        }

        @Override
        public int[] getFrets() {
            return new int[]{1};
        }

        @Override
        public GuitarString[] getGuitarStrings(FretBoard board, int fret) {
            GuitarString[] strings = new GuitarString[0];
            switch (fret) {
                case 1:
                    strings = board.getGuitarStrings(3, 2, 1);
                    break;
            }
            return strings;
        }

    }
}