private final ScheduledExecutorService xpInfoScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
private ScheduledFuture<?> xpInfoUpdatingFuture;

public void actionPerformed() {
    StyledDocument xpInfo = txtXPInfo.getStyledDocument();
    if (btnGo.getText().equals("Go Adventure!")) {
        btnGo.setText("Stop Adventure");
        xpInfoUpdatingFuture = xpInfoScheduledExecutor.scheduleAtFixedRate(
                new XpInfoUpdater(), 0, 1, TimeUnit.SECONDS);
    } else if (btnGo.getText().equals("Stop Adventure")) {
        xpInfoUpdatingFuture.cancel(true);
        btnGo.setText("Go Adventure!");
    }
}

private class XpInfoUpdater implements Runnable {
    @Override
    public void run() {
        SwingUtilities.invokeLater(() -> {
            try {
                xpInfo.insertString(xpInfo.getLength(), "Some string\n", null);
                txtXPInfo.update(txtXPInfo.getGraphics());
            } catch (BadLocationException e) {
                System.out.println(e);
            }
        });
    }
}