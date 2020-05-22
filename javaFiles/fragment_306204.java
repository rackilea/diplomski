// we're outside the EDT
SwingUtilities.invokeLater(new Runnable(){
    @Override
    public void run(){
        // modify Swing component here
    }
});