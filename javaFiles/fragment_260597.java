ActionListener listener = new ActionListener() {

     int count = 0;

     @Override
     public void actionPerformed(ActionEvent e) {
        if (count++==30) {
            screenState = 0;
        }
        repaint();
    }
};

Timer displayTimer = new Timer(1000, listener); // make it 30 times faster