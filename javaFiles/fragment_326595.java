EventQueue.invokeLater(new Runnable() {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(BandListGenerator.class.getName()).log(Level.SEVERE, null, ex);        }
        jProgressBar2.setValue(progress);
    }
});