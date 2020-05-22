import javax.swing.JOptionPane;

public class Example {
    static String bet = "";
    public static void main(String[] args) {
        final JOptionPane pane = new JOptionPane();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pane.getRootFrame().dispose();

            }
        });
        t1.start();
        bet = pane.showInputDialog("give me a value");

        if(bet == null)
            bet = "30";


        System.out.println(bet);
        System.exit(0);
    }
}