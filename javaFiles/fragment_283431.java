@Override
public void initialize(URL location, ResourceBundle resources) {
    OutputStream out = new OutputStream() {
        @Override
        public void write(int b) throws IOException {
            appendText(String.valueOf((char) b));
        }
    };
    System.setOut(new PrintStream(out, true));
}