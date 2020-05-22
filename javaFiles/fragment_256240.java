JFrame frame = new JFrame();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Timer timer = new Timer(1000, (ActionEvent e) -> {
    frame.setTitle(String.valueOf(System.currentTimeMillis()));
});
timer.setRepeats(true);
timer.start();
frame.setVisible(true);