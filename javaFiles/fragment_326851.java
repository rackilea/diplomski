public class DateFormatterAdapter extends Adapter2 {
    private final TimeZone timeZone;

    public DateFormatterAdapter(final TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    @Override
    public Calendar unmarshal(String value) {
        return javax.xml.bind.DatatypeConverter.parseDate(value);
    }

    @Override
    public String marshal(Calendar calendar) {
        return DateConversion.printDate(calendar, timeZone);
    }
}