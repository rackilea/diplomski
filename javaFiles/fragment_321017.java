windowContent.add(p1, BorderLayout.CENTER);
    p2 = new JPanel();
    p2.setLayout(new GridLayout(0,2));
    p2.add(buttonMinus);
    p2.add(buttonPlus);
    p2.add(buttonDivide);
    p2.add(buttonMultiply);
    //p2.add(buttonEqual);  // Oops.. slight correction here!

    //windowContent.add("East", p2);

    JPanel pEast = new JPanel(new GridLayout(0, 1));
    windowContent.add(pEast, BorderLayout.EAST);
    pEast.add(p2);
    pEast.add(buttonEqual);