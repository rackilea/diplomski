private void startBtnActionPerformed(ActionEvent evt) {                                         
    startBtn.setEnabled(false);
    textField.setEditable(true);
    timeLbl.setText("10");

    Timer timer = new Timer(1000, new ActionListener() {
        int t = 9;

        @Override
        public void actionPerformed(ActionEvent e) {
            // each second this function will be called

            timeLbl.setText("" + t);
            if (t == 0) {
                startBtn.setEnabled(true);
                textField.setEditable(false);
                timeLbl.setText("");
                JOptionPane.showMessageDialog(Frame.this, "time up");
                ((Timer) e.getSource()).stop();// Stop the timer
            }
            t--;
        }
    });
    timer.start();// Start the timer
}