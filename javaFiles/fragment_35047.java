contentPane.setLayout(new GridBagLayout());
    ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
    ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 10, 0, 0, 0};
    ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {1.0, 0.0, 1.0, 1.0E-4};
    ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {1.0, 0.0, 0.0, 0.0, 1.0, 1.0E-4};

    //---- leftBtn ----
    leftBtn.setText("left Button");
    contentPane.add(leftBtn, new GridBagConstraints(0, 0, 1, 5, 0.0, 0.0,
        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0), 0, 0));

    //---- rightBtn ----
    rightBtn.setText("right Button");
    contentPane.add(rightBtn, new GridBagConstraints(2, 0, 1, 5, 0.0, 0.0,
        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0), 0, 0));

    //---- addBtn ----
    addBtn.setText("add Button");
    contentPane.add(addBtn, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0), 0, 0));

    //---- remBtn ----
    remBtn.setText("rem Button");
    contentPane.add(remBtn, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0), 0, 0));