public class DateConverter implements Converter {

    private SimpleDateFormat formatter = new SimpleDateFormat(
            "MMMM dd, yyyy HH:mm:ss");

    public boolean canConvert(Class clazz) {
        // This converter is only for Calendar fields.
        return Calendar.class.isAssignableFrom(clazz);
    }

    public void marshal(Object value, HierarchicalStreamWriter writer,
            MarshallingContext context) {
        Calendar calendar = (Calendar) value;
        Date date = calendar.getTime();
        writer.setValue(formatter.format(date));
    }

    public Object unmarshal(HierarchicalStreamReader reader,
            UnmarshallingContext context) {
        GregorianCalendar calendar = new GregorianCalendar();
        try {
            calendar.setTime(formatter.parse(reader.getValue()));
        } catch (ParseException e) {
            throw new ConversionException(e.getMessage(), e);
        }
        return calendar;
    }
}