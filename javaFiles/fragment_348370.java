private class MouseHandler extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                start = true;
                currentLine = new Line();
                currentLine.setFirst(new Point(e.getX(), e.getY()));
                currentLine.setLast(new Point(e.getX(), e.getY()));
                shapes.add(currentLine);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                start = false;
                currentLine.setLast(new Point(e.getX(), e.getY()));
                currentLine = null;
                repaint();
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (start) {
                currentLine.setLast(new Point(e.getX(), e.getY()));
                repaint();
            }
        }
    }