public static void main(String[] args) {
    String x = "foo";
    Holder<String> h = new Holder(x);
    getString(h);
    System.out.println(h.value);
}

public static void getString(Holder<String> output){
    output.value = "Hello World"
}