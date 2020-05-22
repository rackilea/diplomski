//private member used throughout the class
    private int i;
    i = 1;

    next.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            if (i >= 8) {
                                i = 1;
                            } else {
                                i++;
                            }
                            i2 = new ImageIcon(this.getClass().getClassLoader().getResource("image/" + i + ".jpg"));
                            img.setIcon(i2);
                        }
                    });
                }

    //call test() to get the value
    private void test()
    {
                    //Your 'i' variable will have been initialised by the listener method above
                    switch( i )
                    {
                       case 1:
                       //add your code here
                       break;
                       case 2:
                       break;
                       case 3:
                       break;
                       default:
                       break;
                    }
    }