public static void main(String[] args) throws Exception {
    long lvalue = 1234567891011L;
    int ivalue = 1912277059;
    System.out.println(lvalue == ivalue); // false
    System.out.println((int) lvalue == ivalue); // true, but shouldn't
}