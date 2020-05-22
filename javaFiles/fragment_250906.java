table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent arg0) {
                if (arg0.getButton() == MouseEvent.BUTTON1){
                    System.out.println("Left button clicked");
                } else if (arg0.getButton() == MouseEvent.BUTTON2){
                    System.out.println("Middle button clicked");
                } else if (arg0.getButton() == MouseEvent.BUTTON3) {
                    System.out.println("Right button clicked");
                } 
            }
        });