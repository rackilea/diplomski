JLabel label = new JLabel("Click me");
        label.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) { System.out.println("Clicked me!"); }
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
        });