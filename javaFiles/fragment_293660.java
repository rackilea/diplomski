Timer timer = new Timer(5000, new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent arg0) {            
        secondMethod();
    }
});
timer.setRepeats(false);
timer.start()