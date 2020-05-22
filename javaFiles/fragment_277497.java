public class Test3 {
    public Test3() {
        JFrame frame = new JFrame("Exemple");
        JButton button1 = new JButton("Règles");
        JButton button2 = new JButton("Jouer");
        JButton button3 = new JButton("Scores");
        JPanel pane1 = new JPanel(new GridLayout(0, 1));

        pane1.add(button1);
        pane1.add(button2);
        pane1.add(button3);
        frame.getContentPane().add(pane1, BorderLayout.EAST);
        frame.pack();
        frame.setVisible(true);
    }