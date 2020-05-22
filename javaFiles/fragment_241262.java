b.addActionListener(new ActionListener() {     
    public void actionPerformed(ActionEvent arg0) {
        String myString=area.getText();
        JLabel label = new JLabel(myString);
        Font font = new Font("Verdana", Font.BOLD, 12);
        label.setFont(font);
        JOptionPane.showMessageDialog(f.getComponent(0),label);
    }
});