public class DateMillisecsAdapter extends XmlAdapter<String, Long> {

    private DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ssX");

    @Override
    public Long unmarshal(String s) throws Exception {
        if (s == null)
            return null;
        return dateFormat.parse(s).getTime();
    }

    @Override
    public String marshal(Long millisecs) throws Exception {
        if (millisecs == null)
            return null;
        return dateFormat.format(new Date(millisecs));
    }
}