public static void main(String[] args) {

    JFrame frame = new JFrame("Test");

    frame.add(new StepComponent());

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setVisible(true);
}