public class DateXmlAdapter extends XmlAdapter<String, Date> {
    public static final String dateFormat = "yyyy-MM-dd'T'HH:mm:ss";

    @Override
    public Date unmarshal(String v) throws Exception {
        return new SimpleDateFormat(dateFormat).parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return v == null ? "" : new SimpleDateFormat(dateFormat).format(v);
    }
}