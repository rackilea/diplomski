public static void main (String[] args) {
    String s1 = new String("hello");
    String s2 = new String("hello");
    s1 = s1.intern();
    s2 = s2.intern();        
    System.out.println(s1 == s2); // will print true
}