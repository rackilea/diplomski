public static void main (String [] args) {
    example1 one = new example1("Uri");// a name is required
    example2 two = new example2("Uri");// a name is required
    two.setUP(500);

    System.out.println(one.getName());
    System.out.println(two.toString());
}