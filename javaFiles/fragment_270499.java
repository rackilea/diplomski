JButton button = new JButton("Test");
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        new Store(c);
    }
}