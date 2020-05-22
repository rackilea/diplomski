//Label will be 150 (50*3) pixels wide, start at 0,0, and we'll add 30 pixels of padding below it.
GridBagConstraints firstOperandConstraints = new GridBagConstraints(
        0,0,
        3,1,
        1,1,
        GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
        new Insets(0, 0, 30, 0),
        0, 0
        );
//Text field will be 150 (50*3) pixels wide, start at 200(50*4),0, and have 30 pixels of padding below it
GridBagConstraints op1Constraints = new GridBagConstraints(
        4,0,
        3,1,
        1,1,
        GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
        new Insets(0, 0, 30, 0),
        0, 0
        );
//Label will be 150 (50*3) pixels wide, start at 0,200 (50*4), and we'll add 30 pixels of padding below it.
GridBagConstraints secondOperandConstraints = new GridBagConstraints(
        0,4,
        3,1,
        1,1,
        GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
        new Insets(0, 0, 30, 0),
        0, 0
        );
//Field will be 150 (50*3) pixels wide, start at 200,200 (50*4), and we'll add 30 pixels of padding below it.
GridBagConstraints op2Constraints = new GridBagConstraints(
        4,4,
        3,1,
        1,1,
        GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
        new Insets(0, 0, 30, 0),
        0, 0
        );
//Label will be 150 (50*3) pixels wide, start at 0,300 (50*6), and we'll add 30 pixels of padding below it.
GridBagConstraints answerConstraints = new GridBagConstraints(
        0,6,
        3,1,
        1,1,
        GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
        new Insets(0, 0, 30, 0),
        0, 0
        );
//Label will be 150 (50*3) pixels wide, start at 300,300 (50*6), and we'll add 30 pixels of padding below it.
GridBagConstraints ansConstraints = new GridBagConstraints(
        6,6,
        3,1,
        1,1,
        GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
        new Insets(0, 0, 30, 0),
        0, 0
        );
//Button will be 50 pixels wide/tall, start at 0,400 (50*8), and it won't have any padding
GridBagConstraints plusConstraints = new GridBagConstraints(
        0,8,
        1,1,
        1,1,
        GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0),
        0, 0
        );
//Button will be 50 pixels wide/tall, start at 200,400 (50*4/50*8), and it won't have any padding
GridBagConstraints mulConstraints = new GridBagConstraints(
        4,8,
        1,1,
        1,1,
        GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0),
        0, 0
        );