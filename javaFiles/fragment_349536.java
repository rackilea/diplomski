public void setup(Context context) {
    try {
        String constructor = context.getConfiguration().get("ExtractorConstructor");
        this.extractor = (Extractor) construct(constructor);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}