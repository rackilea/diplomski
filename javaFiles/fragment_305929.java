public static void main(final String... args)
        throws IOException {
    try ( final Reader reader = new InputStreamReader(produceResponse()) ) {
        consumeResponse(reader);
    }
}