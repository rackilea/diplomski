public static void main(String[] args) {
    JFrame frame = new JFrame("Glossary");
    frame.setSize(400, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JButton LookUpWord = new JButton("Look up word");  // create the button
    JPanel panel1 = new JPanel();  // create the panel
    panel1.add(LookUpWord);  // add the button to the panel
    frame.add(panel1, BorderLayout.NORTH);  // add the panel to the frame

    JButton SubmitNewWord = new JButton("Submit word");
    JPanel panel2 = new JPanel();
    panel2.add(SubmitNewWord);
    frame.add(panel2, BorderLayout.SOUTH);

    frame.setVisible(true);
}