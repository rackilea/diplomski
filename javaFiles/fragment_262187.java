interface ColumnType {
    String getFormat();
    Class getType();
}

enum SimpleColumnType implements ColumnType {
    TEXT(String.class, "%s"),
    NUMERIC(BigDecimal .class, "%f");

    private Class type;
    private String format;

    SimpleColumnType(Class type, String format) {
        this.type = type;
        this.format = format;
    }

    @Override
    public Class getType() { return type; }

    @Override
    public String getFormat() { return format; }
}

class DateColumnType implements ColumnType {
    private final String format;

    public DateColumnType(String format) {
        this.format = format;
    }

    @Override
    public Class getType() { return LocalDate.class; }

    @Override
    public String getFormat() { return format; }
}