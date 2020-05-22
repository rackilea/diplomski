for (int i = 1; i < label.length; i++) {
    final JLabel currentLabel =new JLabel("label " + i); 
    currentLabel.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent me) {
            currentLabel.setVisible(false);   // No more compilation error here
        }
    });
    label[i] = currentLabel;
}