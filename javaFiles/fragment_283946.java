// code that both the client and server GUI classes share
abstract class DefaultGui implements SimpleGui {

    // this guy ***must**** be volitile!
    private volatile boolean myTurn;
    protected Scanner inputScanner;
    protected PrintStream out;
    protected JButton button = new JButton("Blank");
    protected Socket socket;
    protected String name;
    protected int port;

    public DefaultGui(int port, String name, boolean myTurn) {
        this.port = port;
        this.name = name;
        this.myTurn = myTurn;
    }

    @Override
    public void sendLine(String nextLine) {
        button.setText(nextLine);
        myTurn = true;
    }

    public void createGui() {
        button.addActionListener(e -> actionPerformed(e));
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 300));
        panel.add(button);

        JFrame frame = new JFrame(getName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    protected void actionPerformed(ActionEvent e) {
        if (!myTurn) {
            return;
        }
        out.println(getName());
        button.setText(getName());
        myTurn = false;
    }

    public String getName() {
        return name;
    }

}