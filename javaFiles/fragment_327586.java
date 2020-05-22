final Timer ti = new Timer(0, null);
ti.addActionListener(new ActionListener() {
    int countSeconds = 3;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(countSeconds == 0) {
            lblCountdown.setText("Go");
            ti.stop();
        } else {
            lblCountdown.setText(""+countSeconds);
            countSeconds--;
        }
    }
});
ti.setDelay(1000);
ti.start();