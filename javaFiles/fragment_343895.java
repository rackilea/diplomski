// In another class 
public static void main(String[] args) {
    JPanel paintTester = new MyPaint();
    JFrame frame = new JFrame();
    frame.setSize(400, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.add(paintTester);
    frame.pack();
    frame.setVisible(true);
}