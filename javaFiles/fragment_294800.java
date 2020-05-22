private static <T, E> E read(byte[] bytes, Class<T> sourceClass, Class<E> destClass) throws Exception {
    Decoder decoder = DecoderFactory.get().binaryDecoder(bytes, null);
    DatumReader<E> reader = new SpecificDatumReader<>(
            SpecificData.get().getSchema(sourceClass),
            SpecificData.get().getSchema(destClass));

    return reader.read(null, decoder);
}