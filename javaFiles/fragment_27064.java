add = new JButton ("Add");
add.addActionListener (new ActionListener() {
    @Override
    public void actionPerformed (ActionEvent event) {
        label.setText("Number: " + (++num));
    }
});
subtract = new JButton ("Subtract");
subtract.addActionListener (new ActionListener() {
    @Override
    public void actionPerformed (ActionEvent event) {
        label.setText("Number: " + (--num));
    }
});