public static class HackJsonWriter extends JsonWriter {
    public HackJsonWriter(Writer writer) {
        super(writer);
    }

    private boolean dropQuotes = false;

    public void dropQuotes() {
        dropQuotes = true;
    }

    public void allowQuotes() {
        dropQuotes = false;
    }

    @Override
    protected void addValue(String value, AbstractJsonWriter.Type type)
    {
        if (dropQuotes) {
            super.addValue(value, AbstractJsonWriter.Type.NULL);
        }
        else {
            super.addValue(value, type);
        }
    }
}