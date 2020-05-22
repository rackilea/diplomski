abc temp = new abc();
temp.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "Look Ma, I'm in Main...");
    }
});
temp.setVisible(true);