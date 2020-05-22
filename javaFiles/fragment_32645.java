this.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {

            Component clicked = getComponentAt(e.getPoint());
            if(clicked instanceof JLabel){
                JLabel myLabel = (JLabel) clicked;
                //obviously myLabel is the clicked JLabel
                System.out.println("Clicked Label: " + myLabel.getLocation());
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    });