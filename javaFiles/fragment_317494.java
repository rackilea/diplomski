public class CustomAdapter extends XmlAdapter<String, String>{

    @Override
    public String marshal(String v) throws Exception {
        return "xyz." + v;
    }

    @Override
    public String unmarshal(String v) throws Exception {
        return v.replaceFirst("^xyz.", "");
    }
}