private void jRadioButton1ItemStateChanged(java.awt.event.ItemEvent evt) {
    jRadioButton1.setText("1");
    Timer timer = new Timer(3000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            jRadioButton1.setText("2");
        }
    });
    timer.setRepeats(false);
    timer.start();
}