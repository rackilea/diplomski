public class Chess {

    public static void main(String[] args) {
        new Chess();
    }

    public Chess() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new Board());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public static final int GRID_SIZE = 50;
    public static final boolean SNAP_TO_GRID = false;

    public class Board extends JPanel {

        private BufferedImage board;
        private Point highlightCell;

        public Board() {
            setLayout(new BoardLayoutManager());
            int width = GRID_SIZE * 8;
            int height = GRID_SIZE * 8;
            board = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = board.createGraphics();
            g2d.setColor(Color.WHITE);
            g2d.fill(new Rectangle(0, 0, width, height));
            g2d.setColor(Color.BLACK);
            for (int row = 0; row < 8; row++) {
                int xPos = (row % 2 == 0) ? GRID_SIZE : 0;
                for (int col = 0; col < 8; col += 2) {
                    g2d.fill(new Rectangle(xPos, row * GRID_SIZE, GRID_SIZE, GRID_SIZE));
                    xPos += (GRID_SIZE * 2);
                }
            }
            JLabel piece = new JLabel();
            try {
                piece.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/Luke.png"))));
            } catch (IOException ex) {
                piece.setBackground(new Color(255, 0, 0, 64));
                piece.setOpaque(true);
            }

            add(piece, new Point(0, 0));

            MouseHandler mouseHandler = new MouseHandler(this);
            addMouseListener(mouseHandler);
            addMouseMotionListener(mouseHandler);

        }

        protected Rectangle getBoardBounds() {
            return new Rectangle(getBoardOffset(), new Dimension(GRID_SIZE * 8, GRID_SIZE * 8));
        }

        public Point gridToPoint(Point grid) {
            Point p = new Point();
            if (grid != null) {
                Point offset = getBoardOffset();
                p.x = grid.x * GRID_SIZE + offset.x;
                p.y = grid.y * GRID_SIZE + offset.y;
            }
            return p;
        }

        public Point pointToGrid(Point p) {
            Point grid = null;
            Rectangle board = getBoardBounds();
            if (board.contains(p)) {
                p.x = p.x - board.x;
                p.y = p.y - board.y;

                grid = new Point();
                grid.x = p.x / GRID_SIZE;
                grid.y = p.y / GRID_SIZE;
            }
            return grid;
        }

        public void setPieceGrid(Component comp, Point grid) {
            ((BoardLayoutManager) getLayout()).setPieceGrid(comp, grid);
            invalidate();
            revalidate();
            repaint();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(GRID_SIZE * 8, GRID_SIZE * 8);
        }

        protected Point getBoardOffset() {
            int width = getWidth();
            int height = getHeight();
            Point p = new Point();
            p.x = (width - board.getWidth()) / 2;
            p.y = (height - board.getHeight()) / 2;

            return p;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            Point p = getBoardOffset();
            g2d.drawImage(board, p.x, p.y, this);
            if (highlightCell != null) {
                Point cell = gridToPoint(highlightCell);
                Rectangle bounds = new Rectangle(cell.x, cell.y, GRID_SIZE, GRID_SIZE);
                g2d.setColor(Color.RED);
                g2d.draw(bounds);
            }
            g2d.dispose();
        }

        public void setHightlightCell(Point p) {
            if (highlightCell != p) {
                highlightCell = p;
                repaint();
            }
        }

    }

    public class MouseHandler extends MouseAdapter {

        private Component dragComponent;
        private Board board;
        private Point dragOffset;

        public MouseHandler(Board board) {
            this.board = board;
        }

        public Board getBoard() {
            return board;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            Component comp = getBoard().getComponentAt(e.getPoint());
            if (comp != null) {
                dragComponent = comp;
                dragOffset = new Point();
                dragOffset.x = e.getPoint().x - comp.getX();
                dragOffset.y = e.getPoint().y - comp.getY();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (dragComponent != null) {
                Board board = getBoard();
                Point p = board.pointToGrid(e.getPoint());
                System.out.println(p);
                board.setPieceGrid(dragComponent, p);

                dragComponent = null;
                board.setHightlightCell(null);
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (dragComponent != null) {
                Board board = getBoard();
                Point grid = board.pointToGrid(e.getPoint());
                if (SNAP_TO_GRID) {
                    Point p = board.gridToPoint(grid);
                    dragComponent.setLocation(p);
                } else {
                    Point dragPoint = new Point();
                    dragPoint.x = e.getPoint().x - dragOffset.x;
                    dragPoint.y = e.getPoint().y - dragOffset.y;
                    dragComponent.setLocation(dragPoint);
                }
                board.setHightlightCell(grid);
            }
        }

    }

    public class BoardLayoutManager implements LayoutManager2 {

        private Map<Component, Point> mapGrid;

        public BoardLayoutManager() {
            mapGrid = new HashMap<>(25);
        }

        public void setPieceGrid(Component comp, Point grid) {
            mapGrid.put(comp, grid);
        }

        @Override
        public void addLayoutComponent(Component comp, Object constraints) {
            if (constraints instanceof Point) {
                mapGrid.put(comp, (Point) constraints);
            } else {
                throw new IllegalArgumentException("Unexpected constraints, expected java.awt.Point, got " + constraints);
            }
        }

        @Override
        public Dimension maximumLayoutSize(Container target) {
            return new Dimension(GRID_SIZE * 8, GRID_SIZE * 8);
        }

        @Override
        public float getLayoutAlignmentX(Container target) {
            return 0.5f;
        }

        @Override
        public float getLayoutAlignmentY(Container target) {
            return 0.5f;
        }

        @Override
        public void invalidateLayout(Container target) {
        }

        @Override
        public void addLayoutComponent(String name, Component comp) {
        }

        @Override
        public void removeLayoutComponent(Component comp) {
            mapGrid.remove(comp);
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            return new Dimension(GRID_SIZE * 8, GRID_SIZE * 8);
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return new Dimension(GRID_SIZE * 8, GRID_SIZE * 8);
        }

        @Override
        public void layoutContainer(Container parent) {
            Point offset = ((Board) parent).getBoardOffset();
            for (Component comp : parent.getComponents()) {
                Point p = mapGrid.get(comp);
                if (p == null) {
                    comp.setBounds(0, 0, 0, 0); // Remove from sight :P
                } else {
                    int x = p.x * GRID_SIZE + offset.x;
                    int y = p.y * GRID_SIZE + offset.y;
                    comp.setBounds(x, y, GRID_SIZE, GRID_SIZE);
                }
            }
        }
    }    
}