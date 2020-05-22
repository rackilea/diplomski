class TextAreaOut extends OutputStream implements Runnable {
    JTextArea text;
    String buffer = "";

    TextAreaOut(JTextArea text) {
        this.text = text;
        System.setOut(new PrintStream(this));
    }

    @Override
    public synchronized void run() {
        text.append(buffer);
        buffer = "";
    }

    @Override
    public synchronized void write(int b) throws IOException {
        if(buffer.length() == 0) {
            SwingUtilities.invokeLater(this);
        }
        buffer += (char)b;
    }
}