private Timer timer1 = new Timer(10, new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        rv.y++;



        if (rv.y == 500) {
            timer1.stop();
            jTextArea1.append("Timer 1 Stopped\n");
            jTextArea1.append("Timer 2 Started Moving Up\n");
            timer2.setInitialDelay(0);
            timer2.start();

        }

        rectangle.this.setLocation(rv.x , rv.y);
        rectangle.this.repaint();

    }
});



 private Timer timer2 = new Timer(5, new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
       rv.y--;

        if (rv.y == 200 ) {
            timer2.stop();
            jTextArea1.append("Timer 2 Stopped\n");
        }
          rectangle.this.setLocation(rv.x , rv.y);
         rectangle.this.repaint();
    }
});