class Program {
    // assuming you have these buttons:
    private JButton button1;
    private JButton button2;
    private JButton button3;

    // snip

    public Program() {

        // assuming there's initialization code for the above buttons somewhere...
        // button1 = new ...
        // button2 = new ...
        // button3 = new ...

        // frame initializing
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBounds(100, 100, 890, 480);
        getContentPane().setLayout(null);
        setVisible(true);

        // create the loading bar
        loadingBar = new JProgressBar();
        loadingBar.setBounds(10, 11, 864, 23);
        getContentPane().add(loadingBar);

        // <TODO> disable all buttons
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);

        // animate the loading bar
        Loading thread = new Loading();
        new Thread(thread).start();

        // do not re-enable the buttons here yet.
    }

    // snip

    public class Loading implements Runnable {
        @Override
        public void run() {

            // loop and increment loading bar's value
            for (int i = 0; i <= 100; i++) {
                Program.setProgressBar(i);

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}

            }

            // re-enable the buttons here instead
            button1.setEnabled(true);
            button2.setEnabled(true);
            button3.setEnabled(true);
        }
    }
}