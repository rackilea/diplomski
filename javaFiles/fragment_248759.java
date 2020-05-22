public static void main(String[] args) {
        String s1 = "hello";
        String s2 = s1;
        System.out.println(s2 == s1); // true . Both pointing to same location
s1=null; // s2 still points to "hello"

    }