public static void main(String[] args) 
        throws JsonParseException, JsonMappingException,IOException {
    String json = "{\"a\": \"This is a Test\",\"b\": {\"test1\": \"bla\",\"test2\": \"blub\"}}";
    System.out.println(json);
    JObj obj = new ObjectMapper().readValue(json, JObj.class);
    System.out.println(obj);
}

static class JObj {
    String              a;
    Map<String, String> b;
    public String getA() {return a;}
    public void setA(String a) {this.a = a;}
    public Map<String, String> getB() {return b;}
    public void setB(Map<String, String> b) {this.b = b;}
    @Override
    public String toString() {return "JObj [a=" + a + ", b=" + b + "]";}
}