public class Counter {

    private JFrame frame;
    private JPanel panel;
    private JButton[][] buttons;
    private int[][] isCooperating;
    private Random rand;
    private ActionListener actListner;
    private Timer timer;
    private int n = 0;

    Counter(){
        //do the initialization in the constructor
        buttons  = new JButton[50][50];
        isCooperating = new int[50][50];
        rand = new Random();
        frame = new JFrame("GridLayout demo");
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(new GridLayout(50,50));
        //no need to re construct action listener with each buildGUI run
        actListner = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                    buildGUI();
                    System.out.println("building gui " +n);
                    n++;
                    if(n >=3) {timer.stop();}
            }
        };
        //no need to re construct timer with each buildGUI run
        timer = new Timer(1500, actListner);
        timer.setRepeats(true);
        buildGUI();
    }

    void buildGUI() {

        //remove all components from panel, if any
        //otherwise you keep adding components
        panel.removeAll();
        for (int x = 0; x < 50; x++) {
            for (int y = 0; y < 50; y++) {
                int randomNumber = rand.nextInt(2); // randomly chooses between 1 and 0; for cooperating status
                isCooperating[x][y] = randomNumber; // 1 is cooperating
            }
        }

        for (int x = 0; x < 50; x++) {
            for (int y = 0; y < 50; y++) {
                JButton btn = new JButton();
                if (isCooperating[x][y] == 0) {
                    btn.setBackground(Color.RED);
                    btn.setOpaque(true);
                    btn.setBorder(null);

                } else if (isCooperating[x][y] == 1) {
                    btn.setBackground(Color.BLUE);
                    btn.setOpaque(true);
                    btn.setBorder(null);
                }
                btn.setPreferredSize(new Dimension(10, 10));
                panel.add(btn);
                buttons[x][y] = btn;
            }
        }

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //let layout set size by using pack
        //frame.setSize(800,800);
        frame.pack();
        frame.setVisible(true);
    }

    public void solve() {

        timer.start();
    }

    public static void main(String[]args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Counter().solve();
            }
        });
    }
}