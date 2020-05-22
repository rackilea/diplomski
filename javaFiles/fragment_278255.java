public static class Soundtrack implements Runnable {
    @Override
    public void run() {
        try{
        File file = new File("SF.mp3");
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);

        try{
            Player player = new Player(bis);
            player.play();
        }catch(JavaLayerException ex){}
    }catch(IOException e){}
    }
    }
private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
    // TODO add your handling code here:
        background.stop();     
}                                          
private static Thread background;
public static void main(String args[]) {
    background = new Thread(new Soundtrack());
    background.start();
}