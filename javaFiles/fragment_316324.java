public void run() {
    for(;;){
        try{
            frame.repaint();
            Thread.sleep(40);
        }catch(Exception e){e.toString();}
    }
}