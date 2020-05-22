public void paint(Graphics g){ //Draw function
    Graphics2D g2d = (Graphics2D) g;
    ///////////////////////////////////
    Thread audioThrd = new Thread(new playAudio());
    audioThrd.start();
}