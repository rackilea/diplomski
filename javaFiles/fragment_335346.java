public static void main(final String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);

    // Remove these lines:
    final JFrame jframe = new JFrame("Mi jframe");
    final Canvas canvas = new Canvas();
    jframe.getContentPane().add(canvas);
    jframe.setSize(800, 600);
    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jframe.setVisible(true);
    ...