EventQueue.invokeLater(new Runnable() {

    @Override
    public void run() {
        myPanel.methodCalledOnceDisplayed();
    }
});