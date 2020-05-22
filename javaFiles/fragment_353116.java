private int i = 0;
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    jTextField1.setText(Integer.toString(i++));
                }
            });
        }
    }, 0, 2000);
}