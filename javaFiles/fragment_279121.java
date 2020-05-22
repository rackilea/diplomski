final RegisterStudent panel_1 = new RegisterStudent();
JButton btnNewButton = new JButton("Register Student");
btnNewButton.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent arg0) {
        panel_1.setVisible(true);
    }
});
btnNewButton.setBounds(0, 162, 167, 37);
panel.add(btnNewButton);