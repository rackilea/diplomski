public class GridBagLayoutTest{

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                createAndShowGUI();             
            }
        });
    }

    private static void createAndShowGUI(){
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        final JPanel panel = new JPanel(){
            @Override
            public Dimension getPreferredSize(){
                return new Dimension(200, 20);
            }
        };
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add( new JLabel("|Name|"));
        panel.add(Box.createHorizontalGlue());
        panel.add(new JLabel("|Info|"));
        panel.add(new JLabel("|Tag|"));
        panel.add(new JLabel("|Id|"));

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}