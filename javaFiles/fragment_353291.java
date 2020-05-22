public static class HackRoundedDoubleConverter implements Converter {

    private HackRoundedDoubleConverter() {
    }

    @Override
    public boolean canConvert(Class clazz) {
        return RoundedDouble.class.isAssignableFrom(clazz);
    }

    @Override
    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
        if (value == null) {
            return; // now that i think about it, this should probably write "null" (no quotes), but I was handling that elsewhere
        }
        RoundedDouble number = (RoundedDouble)value;
        if (Double.isNaN(number.getValue()) || Double.isInfinite(number.getValue())) {
            return; // at this point, we would have a problem.  an empty node will be created no matter what (and it translates to an empty object in javascript).
        }

        if (writer.underlyingWriter() instanceof HackJsonWriter) {
            HackJsonWriter hackWriter = (HackJsonWriter)writer.underlyingWriter();
            hackWriter.dropQuotes();
            writer.setValue(number.getRoundedValue());
            hackWriter.allowQuotes();
        }
        else {
            writer.setValue(number.getRoundedValue());
        }
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        // only interested in the one direction
        return null;
    }
}