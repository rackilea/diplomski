public static void main(String[] args) throws Exception {       
    ObjectMapper mapper = new ObjectMapper();
    MyClass a = new MyClass();
    ObjectNode node = mapper.<ObjectNode>valueToTree(a);
    node.put("blah", "123");
    System.out.println(node);
}

static class MyClass {
    private String value = "some text";
    private long timestamp = System.currentTimeMillis();
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}