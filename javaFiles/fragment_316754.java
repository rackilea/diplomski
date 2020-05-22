@XmlJavaTypeAdapter(CDATAXmlAdapter.class)
public final static String space = "...";

private static class CDATAXmlAdapter extends XmlAdapter<String, String> {
    @Override
    public String marshal(final String value) throws Exception {
        // you may want to apply additional value escaping to avoid
        // CDATA nesting problem
        return "<![CDATA[" + value + "]]>";
    }

    @Override
    public String unmarshal(final String value) throws Exception {
        // If you expect that server will send CDATA as well
        // then you need to strip CDATA from value
        return value;
    }
}