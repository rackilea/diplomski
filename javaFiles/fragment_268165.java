public class Aquarium extends JPanel {

    public static final int NUMNBER_OF_FISHIES = 12;

    private BufferedImage masterFish;
    private Vector<Fish> fishes = new Vector<Fish>(NUMNBER_OF_FISHIES);
    private int sleepTime = 110;

    public Aquarium() {

        //set the title and assign tracker object

        try {
            masterFish = ImageIO.read(getClass().getResource("/gnome_panel_fish.png"));
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }

        // This is a little cheat which means you only ever need one fish image
        // Basically it will flip the master along it's horizontal axies ;)
        BufferedImage flippedMaster = new BufferedImage(masterFish.getWidth(), masterFish.getHeight(), masterFish.getType());
        Graphics2D g2d = flippedMaster.createGraphics();
        g2d.setTransform(AffineTransform.getScaleInstance(-1, 1));
        g2d.drawImage(masterFish, -masterFish.getWidth(), 0, this);
        g2d.dispose();

        for (int index = 0; index < NUMNBER_OF_FISHIES; index++) {
            fishes.add(new Fish(masterFish, flippedMaster, this));
        }

        Thread background = new Thread(new Background());
        background.setDaemon(true);
        background.start();

    }

    public static void main(String ar[]) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException classNotFoundException) {
                } catch (InstantiationException instantiationException) {
                } catch (IllegalAccessException illegalAccessException) {
                } catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
                }

                JFrame frame = new JFrame("The Aquarium ");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new Aquarium());
                frame.setSize(400, 400);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        for (Fish fish : fishes) {
            fish.drawFishImage(g);
        }

    }

    protected class Background implements Runnable {

        @Override
        public void run() {

            while (true) {

                for (Fish fish : fishes) {
                    fish.swim();
                }

                try {
                    Thread.sleep(sleepTime);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                repaint();
            }
        }
    }
}