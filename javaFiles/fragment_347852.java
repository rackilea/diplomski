private void pressEnterToContinue() {
    while (true) {
        int c;
        try {
            c = System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (c == -1 || c == '\n') return;
    }
}