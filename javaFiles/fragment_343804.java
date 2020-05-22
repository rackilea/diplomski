public class TimerFrame {
    private static JFrame frame = new JFrame();

    public static void main(String[] args) {
        TimerFrame timerFrame = new TimerFrame();
        timerFrame.frame.setVisible(true);
        timerFrame.frame.setSize(400,100);
        new Timer().schedule(new TimerTask(){

            int second = 60;
            @Override
            public void run() {
                frame.setTitle("Application will close in " + second-- + " seconds.");
            }   
        },0, 1000);
    }
}