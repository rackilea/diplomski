String value = "number_to_be_parsed".trim();
NumberFormat formatter = NumberFormat.getNumberInstance();
ParsePosition pos = new ParsePosition(0);
Number parsed = formatter.parse(value, pos);
if (pos.getIndex() != value.length() || pos.getErrorIndex() != -1) {
    throw new RuntimeException("my error description");
}