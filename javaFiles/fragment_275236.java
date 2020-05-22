class ButtonListener implements ActionListener {
    long previousEventEnd;
    public void actionPerformed(ActionEvent e) {
        if (e.getWhen() <= previousEventEnd ) {
            log.tracef("discarding stale event, event occurred at  %1$tb %1$te %1$tY %1$tT.%1$tL",
                    new Date(e.getWhen()));
            return;
        }
        log.infof("LoginWindow.ButtonListener.actionPerformed(). Event occurred at %1$tb %1$te %1$tY %1$tT.%1$tL",
                new Date(e.getWhen()));
        LoginWindow.this.repaint(50);
        SwingUtilities.invokeLater( new Runnable() {
            @Override
            public void run() {
                verifyLogin();
                previousEventEnd = System.currentTimeMillis();
            }
        });
    }
}