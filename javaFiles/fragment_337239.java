private class MyTimerListener implements ActionListener {
    private long startTime = 0;

    public void reset() {
        startTime = System.currentTimeMillis();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        long time = System.currentTimeMillis();
        long delta = (time - startTime) / 10L;
        label.setText(String.valueOf(delta));
    }
}