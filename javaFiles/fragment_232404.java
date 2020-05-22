DateFormat axisDateFormat = dateAxis.getDateFormatOverride();
        if (axisDateFormat == null) {
            axisDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        }
        dateAxis.setDateFormatOverride(new SelectiveDateFormat(axisDateFormat, Calendar.MONTH, 0));

...

class SelectiveDateFormat extends DateFormat {
    private final DateFormat format;
    private final int dateField;
    private final int fieldValue;

    public SelectiveDateFormat(DateFormat format, int dateField, int fieldValue) {
        this.format = format;
        this.dateField = dateField;
        this.fieldValue = fieldValue;
    }

    @Override
    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
        Calendar calendar = Calendar.getInstance(format.getTimeZone());
        calendar.setTime(date);
        int value = calendar.get(dateField);
        if (value == fieldValue) {
            format.format(date, toAppendTo, fieldPosition);
        }
        return toAppendTo;
    }

    @Override
    public Date parse(String source, ParsePosition pos) {
        return format.parse(source, pos);
    }
}