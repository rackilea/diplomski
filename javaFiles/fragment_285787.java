int delay=1000;// wait for second

Timer timer = new Timer(delay, new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent ae) {
        //action that you want performed 
    }
});
//timer.setRepeats(false);//the timer should only go off once
timer.start();