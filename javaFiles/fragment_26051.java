InputSupplier<InputStream> supplier = new InputSupplier<InputStream>() {
        @Override
        public InputStream getInput() throws IOException {
            InputStream inStream = new FileInputStream("mime");
            InputStream decodedStream=null;
            try {
                decodedStream = MimeUtility.decode(inStream,
                "quoted-printable");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            return decodedStream;
        }
    };
    InputSupplier<InputStreamReader> result = CharStreams
    .newReaderSupplier(supplier, Charsets.ISO_8859_1);
    String ans = CharStreams.toString(result);
    System.out.println(ans);