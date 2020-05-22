public MainFrame(){
    ////////////////////////////resizing

    contentPane = new JPanel();
    contentPane.setLayout(new CardLayout(20,20));

    addPanels();

    this.add(this.contentPane); // I added this

    ////////////////////////listener for closing
}