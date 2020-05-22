EventQueue.invokeLater(new Runnable(){
    public void run(){
        firstProgressBar.setValue(someInt);
        secondProgressBar.setValue(someOtherInt);
    }
});