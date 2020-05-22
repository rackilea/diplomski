while(true) {
    showStatus(MineButton.flagCount + "");

     try {
        Thread.sleep(1000);
    } catch (InterruptedException ex) {
        Logger.getLogger(Str.class.getName()).log(Level.SEVERE, null, ex);
    }
}