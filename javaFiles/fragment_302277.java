public static final MyPayLoad parseBinaryPayload(byte[] payload) {
        DatumReader<MyPayLoad> payloadReader = new SpecificDatumReader<>(SCHEMA_V1, SCHEMA_V2);
        Decoder decoder = DecoderFactory.get().binaryDecoder(payload, null);
        MyPayLoad myPayLoad = null;
        try {
            myPayLoad = payloadReader.read(null, decoder);
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }

        return myPayLoad;
    }