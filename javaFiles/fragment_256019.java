//Create three radio buttons   
        JRadioButton aButton = new JRadioButton("A",true);
        JRadioButton bButton = new JRadioButton("B");
        JRadioButton cButton = new JRadioButton("C");

        //Create a ButtonGroup object, add buttons to the group
        ButtonGroup myButtonGroup = new ButtonGroup();
        myButtonGroup.add(aButton);
        myButtonGroup.add(bButton);
        myButtonGroup.add(cButton);

        //Display radio buttons
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(aButton);
        getContentPane().add(bButton);
        getContentPane().add(cButton);
        setSize(250,100);
        setTitle("Swing Radio Buttons");
        setVisible(true);