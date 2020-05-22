JButton reset = new JButton("Reset");
        reset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                recx = 150; recy = 150;
                repaint();
            }
        });