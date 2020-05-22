public class MainWindow {
    private JPanel panelMain; // panelMain is not initialized, so when you try to add it to any window/panel, you'll get a NullPointerException
    private JButton buttonCalculate; // same as before. Also this button is not added to any container (window/panel)
    private JPanel panelPlot; // panel is not added to any container

    public MainWindow() {
        buttonCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPlot = new MyPanel();
                panelPlot.setBackground(Color.CYAN);
                panelPlot.setSize(200, 200); // this code will not be honored because the layout manager will recalculate panel bounds.
                                             // use setPreferredSize instead.
                panelPlot.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("MyFirstGraphTool");
        f.setContentPane(new MainWindow().panelMain);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 400);
        f.setVisible(true);
    }
}