public class RectangleComponent extends JPanel {

        private List<Rectangle> boxes;
        private int width = 30;
        private int height = 40;
        private int startX = 10;
        private int startY = 20;

        public RectangleComponent() {
            boxes = new ArrayList<Rectangle>();
            for (int i = 0; i < 3; i++){
                boxes.add(new Rectangle(startX+(width+startX)*i, startY, width, height));
            }
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            for (int i = 0; i < boxes.size(); i++){
                g2.draw(boxes.get(i));
            }
            g2.setColor(Color.BLUE);
            for (int i = 0; i < boxes.size(); i++){
                g2.fill(boxes.get(i));
            }

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(boxes.size()*(width+startX)+startX, height+startY*2);
        }

    }