final Timer updater = new Timer(3000, new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // update JTextField
    }
});
JButton button = new JButton("Click me!");
button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        updater.start();
    }
});