JButton moveButton = new JButton("Move");
                  moveButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        testBug.move();

                        repaint();
                    }
                });

            JButton turnButton = new JButton("Turn");
                turnButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        testBug.turn();
                        repaint();
                    }
                });