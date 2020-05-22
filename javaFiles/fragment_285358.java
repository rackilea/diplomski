public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (myNetwork!=null) {
                drawNetwork(myNetwork, this, g);
            }
        }