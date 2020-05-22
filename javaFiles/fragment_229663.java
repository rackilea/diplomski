public void saveAndDisplay() throws InterruptedException{
//printing error message
if(saveValuesToDatabase()){
    ...
}
Timer timer = new Timer(5000, new ActionListener() {    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        doSomethingElse();
    }
    });
    timer.setRepeats(false);
    timer.start();
}