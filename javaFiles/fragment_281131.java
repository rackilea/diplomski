class NullableReprinter {
    void reprint(InputStream is) throws IOException {
        if (is != null) {
            System.out.println(is.read());
        }
    }
    void bla() {
        reprint(null);
    }
}