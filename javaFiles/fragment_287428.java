private static final int X_INC = 5;
...
Timer timer = new Timer(40, new ActionListener(){
    public void actionPerformed(ActionEvent e) {
        for (Pipe pipe : pipes ){
            if (pipe.x >= screenWidth) {
                pipe.x = 0;
            } else {
                pipe.x += X_INC;
            }
        }
        repaint();
    }
});