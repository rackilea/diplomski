public class GraphicsMovement extends JApplet {

    @Override
    public void init() {
        setLayout(new BorderLayout());
        add(new AnimatedPane());
    }

    @Override
    public void start() {
    }

    public class AnimatedPane extends JPanel {

        private Timer timer;
        private boolean colorSwitch = false;

        private int yOffset = 0;
        private int direction = 1;

        public AnimatedPane() {
            timer = new Timer(10, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
//                    colorSwitch = !colorSwitch;
                    yOffset += direction;
                    if (yOffset > 100) {
                        direction = -1;
                        yOffset = 100;
                    } else if (yOffset < 0){
                        direction = 1;
                        yOffset = 0;
                    }
                    repaint();
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();

            setBackground(new Color(140, 214, 225));
        }

        @Override
        protected void paintComponent(Graphics page) {
            super.paintComponent(page);
            int width = getWidth();    // width = the width of the panel which appears when run
            int height = getHeight();  // height = the height of the panel which appears when run.

            if (colorSwitch) {
                page.setColor(new Color(140, 214, 225));
            } else {
                page.setColor(Color.YELLOW);
            }
            page.fillOval(100, 55 + yOffset, 100, 100);  //draws a yellow oval
        }
    }
}