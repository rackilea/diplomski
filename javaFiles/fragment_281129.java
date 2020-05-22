class ComposableReprinter {
    void reprint(InputStream is) throws IOException {
        System.out.println(is.read());
    }

    void bla() {
        reprint(InputStream.nullInputStream());
    }
}