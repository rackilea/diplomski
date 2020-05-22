/**
 * Notice there's only one thing in this that isn't defined:
 * It still needs public abstract void triggerEvent();
 */
public abstract static class TopButton extends JPanel implements MouseListener {
        protected ButtonPanel parent;
        private String text;
        public TopButton(ButtonPanel bp, String text) { parent = bp; this.text = text; addMouseListener(this); }
        public void mouseClicked(MouseEvent e) { triggerEvent(); }
        public void mouseEntered(MouseEvent e) { }
        public void mouseExited(MouseEvent e) { }
        public void mousePressed(MouseEvent e) { }
        public void mouseReleased(MouseEvent e) { }
        public abstract void triggerEvent();
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Color oldColor = g.getColor();
            Font oldFont = g.getFont();
                Font newFont = new Font(oldFont.getName(),oldFont.getStyle(),oldFont.getSize());
                g.setFont(newFont);
                g.setColor(Color.black);
                g.drawString(text, 20, 20);
            g.setFont(oldFont);
            g.setColor(oldColor);
        }
    }