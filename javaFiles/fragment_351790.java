public class Skyline extends JFrame {

    private int num = 0;
    private Building bldg1 = new Building(305, 110, 30);
    private Building bldg2 = new Building(380, 125, 170);
    private Building bldg3 = new Building(245, 200, 325);
    private Building bldg4 = new Building(470, 170, 555);
    private Building bldg5 = new Building(395, 200, 755);
    private Background bg = new Background();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                Skyline f = new Skyline();

                f.setSize(1017, 661); //Sets size of window
                f.setTitle("Skyline"); //Sets title of window
                f.setVisible(true);
            }
        });
    }

    public Skyline() {
        setLayout(new BorderLayout());
        add(new SkyLinePane());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public class SkyLinePane extends JPanel {

        private Image mImage; //Image buffer
        private boolean painting = false;

        private int mX, mY; //Mouse cooddinates

        public SkyLinePane() {
            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent me) {
                    mX = (int) me.getPoint().getX();
                    mY = (int) me.getPoint().getY();
                    repaint();
                }
            });

        }

        protected void updateBuffer() {
            if (!painting && mImage == null) {
                painting = true;
                new BackgroundPainter(this).execute();
            }
        }

        //====================================BUFFER CODE========================================
        @Override
        public void paintComponent(Graphics g) {
            Dimension d = getSize();
            if (mImage != null) {
                g.drawImage(mImage, 0, 0, null);
            } else {
                updateBuffer();
            }
            g.setColor(Color.RED);
            g.drawOval(mX - 5, mY - 5, 10, 10);
        }
        //=======================================================================================

        protected void setBackground(Image image) {
            mImage = image;
            painting = false;
            repaint();
        }
    }

    public class BackgroundPainter extends SwingWorker<Image, Image> {

        private SkyLinePane skyLinePane;

        public BackgroundPainter(SkyLinePane skyLinePane) {
            this.skyLinePane = skyLinePane;
        }

        @Override
        protected Image doInBackground() throws Exception {
            Dimension d = skyLinePane.getSize();

            Image backgroundBuffer = null;
            if (d.width > 0 && d.height > 0) {

                System.out.println("Paint offscreen...");
                backgroundBuffer = createImage(d.width, d.height);
                Graphics offG = backgroundBuffer.getGraphics();
                offG.setColor(getBackground());
                offG.fillRect(0, 0, d.width, d.height);

                //Save frame to buffer
                paintOffscreen(offG);

                offG.dispose();
                System.out.println("Done Paint offscreen...");

            }

            return backgroundBuffer;
        }

        @Override
        protected void done() {
            try {
                skyLinePane.setBackground(get());
            } catch (ExecutionException exp) {
                exp.printStackTrace();
            } catch (InterruptedException exp) {
                exp.printStackTrace();
            }
        }

        public void paintOffscreen(Graphics page) {
            //Draws the background
            bg.draw(page);

            //Moving square
            num++;
            if (num > 1200) {
                num = 0;
            }
            page.setColor(Color.yellow);
            page.fillRect(num, 100, 100, 100);

            //Draws the buildings
            bldg1.draw(page);
            bldg2.draw(page);
            bldg3.draw(page);
            bldg4.draw(page);
            bldg5.draw(page);
        }
    }

    //=======================================================================================
    public class Windows {

        private Random gen = new Random();
        private int height, width, locX;
        private int onOff = 0;

        public Windows() {
            height = 305;
            width = 110;
            locX = 30;
        }

        public Windows(int height, int width, int locX) {
            this.height = height;
            this.width = width;
            this.locX = locX;
        }

        public void draw(Graphics page) {
            page.setColor(Color.darkGray);

            page.fillRect(locX, 550 - height, width, height);

            for (int i = 550 - height + 5; i < 550; i += 15) {
                for (int x = locX + 5; x < locX + width; x += 15) {
                    onOff = gen.nextInt(2);

                    if (onOff == 0) {
                        page.setColor(Color.black);
                    } else {
                        page.setColor(Color.yellow);
                    }

                    page.fillRect(x, i, 10, 10);
                }
            }
        }
    }

    public class Building {

        private int height, width, locX;
        private int onOff;
        private Windows windows1;// = new Windows(height, width, locX);

        public Building() {
            height = 305;
            width = 110;
            locX = 30;

            windows1 = new Windows(height, width, locX);
        }

        public Building(int height, int width, int locX) {
            this.width = width;
            this.height = height;
            this.locX = locX;

            windows1 = new Windows(height, width, locX);
        }

        public void draw(Graphics page) {
            page.setColor(Color.darkGray);

            page.fillRect(locX, 550 - height, width, height);

            windows1.draw(page);
        }
    }

    public class Background {

        private int height, width;

        public Background() {
            height = 400;
            width = 2000;
        }

        public Background(int height, int width) {
            this.height = height;
            this.width = width;
        }

        public void draw(Graphics page) {
            //Draws the sky
            page.setColor(Color.cyan);
            page.fillRect(0, 0, 2000, 2000);
            //Draws the grass
            page.setColor(Color.green);
            page.fillRect(0, 500, width, height);
        }
    }
}