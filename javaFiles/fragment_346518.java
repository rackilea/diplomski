class MyListener implements ActionListener {

    private final int index;

    // add more fields for other required parameters

    public MyListener(int index) {
        this.index = index;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      // use index    
    }
}