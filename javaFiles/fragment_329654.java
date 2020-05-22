colorButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
        Color color = JColorChooser.showDialog(null, "title", null);

        if (color != null) {
            colorButton.setBackground(color);
        }
    }
});