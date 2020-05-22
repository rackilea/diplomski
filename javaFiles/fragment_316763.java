frame.addMouseListener(new MouseAdapter() {

        public void mousePressed(MouseEvent e) {

             // Check if the point where the mouse was clicked is contained
             // within the drawing Rectangle.                          
             if (new Rectangle(6, 10, 66, 70).contains(e.getPoint())) {
                    object.switchColor();
                    object.revalidate();
                    object.repaint();
             }
         }
    });