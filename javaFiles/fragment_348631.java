public void actionPerformed (ActionEvent e) {
    // I'd be disabling the buttons here to prevent
    // the user from trying to trigger another 
    // update...

    // This is an instance field which is used by your
    // listener
    choice = e.getSource();

    Timer timer = new Timer(1000, listener);
    timer.setRepeats(false);
    timer.start();
}