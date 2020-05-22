JButton button = new JButton("Test");
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(menuSelection == 1) {
            new Store(c);
        }
    }
}