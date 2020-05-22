public class MyDateFormatAdapter extends XmlAdapter<String, Date> {

    private static final DateFormat dateFormat = 
        new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);

    @Override public Date unmarshal(String v) throws Exception {
        return dateFormat.parse(v);
    }

    @Override public String marshal(Date d) throws Exception { 
        return dateFormat.format(d);
    }
}