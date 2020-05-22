getRootPane().setGlassPane(new WaitPanel());
getRootPane().getGlassPane().setVisible(true);

int delay = 4 * 1000; // 4 second delay
new javax.swing.Timer(delay, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        getRootPane().getGlassPane().setVisible(false);
        ((javax.swing.Timer) e).stop();
    }
}).start();