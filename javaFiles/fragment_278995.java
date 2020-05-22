column1 = new JLabel[6];
    column2 = new JLabel[6];
    column3 = new JLabel[6];
    column4 = new JLabel[6];
    column5 = new JLabel[6];
    column6 = new JLabel[6];
    column7 = new JLabel[6];

    for (int j = 0; j < 6; j++) {
        column1[j] = new JLabel(emptySlot);
        column2[j] = new JLabel(emptySlot);
        column3[j] = new JLabel(emptySlot);
        column4[j] = new JLabel(emptySlot);
        column5[j] = new JLabel(emptySlot);
        column6[j] = new JLabel(emptySlot);
        column7[j] = new JLabel(emptySlot);
        this.add(column1[j]);
        this.add(column2[j]);
        this.add(column3[j]);
        this.add(column4[j]);
        this.add(column5[j]);
        this.add(column6[j]);
        this.add(column7[j]);
    }