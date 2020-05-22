JButton btnNewButton_1 = new JButton("Encrypt");
btnNewButton_1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        Encrypter.encrypt(content);
    }
});