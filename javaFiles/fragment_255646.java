sqldetails() {
    .....

    // JTextField utext=new JTextField(9); //====> shadows the instance variable utext
    this.utext=new JTextField(9); // This is the correct use
    panel.add(utext);
    addItem(panel,utext,1,0,1,1,GridBagConstraints.WEST);

    .......

    // JTextField ptext=new JTextField(9); //=====> shadows the instance variable ptext
    this.ptext = new JtextField();  // This is the correct use

    .......
}