ActionListener listener = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < dots.size();i++) {
                    dots.get(i).x = dots.get(i).x + rn.nextInt(20)-10;
                    dots.get(i).y = dots.get(i).y + rn.nextInt(20)-10;
                }
                drawPanel.repaint();
        }
    };