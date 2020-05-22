buttonoptions.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent a) {
                labelboxoptions.setBorder(boxborder);
                labelbackground.add(labelboxoptions);
                labelboxoptions.setVisible(true);
                menupanel.repaint();

            }

 });