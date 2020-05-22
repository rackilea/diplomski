JButton jButton_sete = new JButton("Set Choice");
    jButton_sete.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
    drawColor = JColorChooser.showDialog(null, "Set Choice",choice);
        if (choice != null) {
            g2dImg.setPaint(choice);
    });