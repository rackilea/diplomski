public static void main(String[] args) throws FileNotFoundException {
    System.out.println("1");
    System.setOut(new PrintStream(new OutputStream() {
        @Override
        public void write(int arg0) throws IOException {
            // TODO Auto-generated method stub

        }
    }));
    System.out.println("2");
}