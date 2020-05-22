Timer timer = new Timer(1000, new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        rad++;
        if (rad < 200) {
            repaint();
        } else {
            ((Timer)evt.getSource()).stop();
        }
    }
});
timer.start();