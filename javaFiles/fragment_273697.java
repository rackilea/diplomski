public void actionPerformed(ActionEvent e) {
    codeLabel=new JLabel(area4Label.getText());
    codeLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    codeLabel.setBounds(50, 20, 100, 100);
    magnet.add(codeLabel);
    magnet.repaint();
    area4Label.setText("");
}