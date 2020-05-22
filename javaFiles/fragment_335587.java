int timerDelay = 50; // msec
new Timer(timerDelay, new ActionListener() {
    private int counter = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        counter++;
        if (counter == 10){
            ((Timer)e.getSource()).stop();
        }
        setOpacity(counter * 0.1F);
    }
}).start();