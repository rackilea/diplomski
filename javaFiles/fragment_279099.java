digitalPinRadioButtonArray[x][y].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    if(e.getActionCommand().equals("Output"))
                            {
                                    digitalPinOutputArray[2].setSelected(true);
                            }

                }
            });