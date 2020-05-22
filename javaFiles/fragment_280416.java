public static void main(String[] args) throws Exception {

    JFrame frame = new JFrame("Test");

    frame.add(new JPanel() {{ this.add(new JButton("Add")); }});

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
}