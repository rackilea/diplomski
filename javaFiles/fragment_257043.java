public static void main(String[] args) {

    float original = 0.2f;
    float multiplied  = original *10000;
    int intvalue = (int)multiplied; // you can change to round up/down

    String d = String.format("%04d", intvalue);
    System.out.println("Value d : "+d);

}