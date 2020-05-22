class Demo {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,400);

        JPanel ScrollPanes = new JPanel();
        frame.getContentPane().add(ScrollPanes, BorderLayout.CENTER);
        ScrollPanes.setLayout(new GridLayout(0, 2, 0, 0));

        JTextPane textPane_0 = new JTextPane();
        JScrollPane jScrollPane1 = new JScrollPane(textPane_0);
        jScrollPane1.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        ScrollPanes.add(jScrollPane1);


        JTextPane textPane_1 = new JTextPane();
        JScrollPane jScrollPane2 = new JScrollPane(textPane_1);
        jScrollPane2.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        ScrollPanes.add(jScrollPane2);


        frame.setVisible(true);


    }
}