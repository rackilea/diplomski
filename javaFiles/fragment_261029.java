class TripleValue {
    String A;
    String B;
    int C;

    public TripleValue(String a, String b, int c) {
        A = a;
        B = b;
        C = c;
    }
}

public static void main() {
    Map<String, TripleValue> myMap = new HashMap<String, TripleValue>(); 
    myMap.put("SomeKey", new TripleValue("String1", "String2", 10));

}