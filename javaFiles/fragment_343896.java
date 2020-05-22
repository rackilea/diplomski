JFrame frame = new JFrame();
     frame.add(new JPanel(){
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.YELLOW);
            g.fillRect(50, 50, 100, 100);
        }

     });