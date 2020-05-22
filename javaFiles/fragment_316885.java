public class Square extends JComponent{

        private int length; 

        public Square(int length) {
            this.length = length;
        }
        public double getArea() {   
        return length * length;
        }
        public int getPerimeter() {
            return length * 4;
        }
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            Rectangle square = new Rectangle(100,100,length,length);
            g2.draw(square);


        }
    }