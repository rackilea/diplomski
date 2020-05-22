public class Test {     
    private HashMap<String, Long> props = new HashMap<>();

    public Test() {
        props.put("prop1", 0L);
        props.put("prop2", 0L);
    }

    public void setProp1(long prop1) {
        props.put("prop1", p);
    }

    public void setProp2(long prop2) {
        props.put("prop2", p);
    }

    public long getProp1() {
        props.get("prop1");
    }

    public long getProp2() {
        props.get("prop2");
    }

    public void prepareForSerialization() {
        props.remove("prop2");
    }
}