public static void main(String[] args) {
    Integer a = 1;
    Integer b = 0;
    b=a;                      // 2 references a and b point to same Integer object
    System.out.println(a);
    System.out.println(b);
    ++a;                      // now a references to a new integer object with value 2 where as b refers to old integer object with value 1
    System.out.println(a);
    System.out.println(b);
}