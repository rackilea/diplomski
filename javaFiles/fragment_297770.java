class MyActionListener implements ActionListener {

    JMenuItem item;

    MyActionListener(JMenuItem item) {
        this.item = item;
    }

    public void actionPerformed(ActionEvent e) {
        // here you have the reference for the item. Printing the text:
        System.out.println(item.getText());
    }

}