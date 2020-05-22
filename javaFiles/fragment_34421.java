public MainPanel() {
    initComponents();
    pack();
    insert = new Insert();
    view = new View();
    read = new Read(view); // *********
    jPanel2.add(insert);
    jPanel2.add(view);
    jPanel2.add(read);
    insert.setVisible(true); // Initially only insert is visible later on
    view.setVisible(false);  // I have buttons which set's the view and
    read.setVisible(false);  // read visible

}