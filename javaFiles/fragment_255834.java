downbutton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        y++; // The "up" button should be y--, because the y axis points down
        drawpanel.repaint();
    }
});