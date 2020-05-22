ButtonsPanel(final MyJPanel parent){
    this.parent = parent;
    setLayout(new FlowLayout());
    add(addLineButton);
    add(addRectButton);
    //show me the Panel size :)
    this.setBackground(Color.RED);