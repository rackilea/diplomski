Timer timer = new Timer(1000, new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent arg0) {            
        // start loading animation now
    }
});
timer.setRepeats(false);
timer.start()