public static class SaveableReaderBasedJsonParser extends ReaderBasedJsonParser {
    private int savedInputPtr = -1;

    public SaveableReaderBasedJsonParser(IOContext ctxt, int features, Reader r, ObjectCodec codec, CharsToNameCanonicalizer st, char[] inputBuffer, int start, int end, boolean bufferRecyclable) {
        super(ctxt, features, r, codec, st, inputBuffer, start, end, bufferRecyclable);
    }

    public void save() {
        savedInputPtr = _inputPtr;
    }

    public boolean isSaved() {
        return savedInputPtr>-1;
    }

    public void load() {
        _currToken = JsonToken.START_OBJECT;
        _inputPtr = savedInputPtr;
        _parsingContext = _parsingContext.createChildObjectContext(0, 0);
    }
}