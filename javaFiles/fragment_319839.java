public class OvalPanel extends JPanel {
            Oval oval;
            int x = 50;
            int y = 10;
            int diameter = 50;
            Color color = Color.BLUE;

            public void moveToCoord(MouseEvent e) {
                x = e.getX() - diameter / 2;
                y = e.getY() - diameter / 2;
                repaint();

            }

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                oval = new Oval(x, y, diameter, color);
                oval.draw(g);

            }

        }