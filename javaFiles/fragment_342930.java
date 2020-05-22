EventQueue.invokeLater(new Runnable() {
    @Override
    public void run() {
        new CandlestickDemo("GOOG").setVisible(true);
    }
});