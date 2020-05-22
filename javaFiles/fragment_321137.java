JButton l = new JButton("Submit");
p.add(l);
p.add(new JLabel());
SpringUtilities.makeCompactGrid(p,
                                labelsLength + 1, 2, //rows, cols
                                7, 7,        //initX, initY
                                7, 7);       //xPad, yPad