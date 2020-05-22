class ControllableReprinter {
    void reprint(InputStream is, boolean for_real) throws IOException {
        if (for_real) {
            System.out.println(is.read());
        }
    }
    void bla() {
        reprint(new BufferedInputStream(), false);
    }
}