public static void main(String[] args) {
    JFrame frame = new JFrame();

    JTextField field = new JTextField();
    frame.add(field);

    frame.pack();
    frame.setVisible(true);

    OutputStream out = new OutputStream() {
        @Override
        public void write(int b) throws IOException {
        }
    };

    class JTextFieldPrintStream extends PrintStream {
        public JTextFieldPrintStream(OutputStream out) {
            super(out);
        }
        @Override
        public void println(String x) {
            field.setText(x);
        }
    };
    JTextFieldPrintStream print = new JTextFieldPrintStream(out);
    System.setOut(print);

    System.out.println("hello");
}