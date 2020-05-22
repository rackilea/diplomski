public void init() {
    RepaintScheduler scheduler = new RepaintScheduler();
    // Add listeners that call scheduler.pause and scheduler.resume
    btn_increment.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
        scheduler.resume();
    }});
    btn_decrement.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
        scheduler.pause();
    }});
    // Now start everything up
    Thread t = new Thread(scheduler);
    t.start();
}