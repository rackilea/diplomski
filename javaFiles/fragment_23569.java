public class MyObj {
    @XStreamAsAttribute
    private String filed;

    public String getField() {
        return filed;
    }

    public void setField(String value) {
        this.filed = value;
    }

    public static void main(String[] args)
    {
        XStream xstream = new XStream(new DomDriver("UTF-8"));
        MyObj obj = new MyObj();
        obj.setField("field value");
        xstream.toXML(obj, System.out);
    }
}