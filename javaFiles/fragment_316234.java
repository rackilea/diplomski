public class Main {

    public static GlassPane glass;
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("GlassPaneDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(200,200));

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(new JLabel("asdasda"),BorderLayout.CENTER);
        GlassPane myGlassPane = new GlassPane();
        JButton myButton =  initButton(myGlassPane);

        contentPane.add(myButton,BorderLayout.PAGE_END);
        frame.setGlassPane(myGlassPane);
        frame.pack();
        frame.setVisible(true);
    }

    private static JButton initButton(final GlassPane myGlassPane) {
        JButton button = new JButton("Start & Stop Loading");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    myGlassPane.activate(!myGlassPane.isVisible());
            }
        });
        return button;
    }

}