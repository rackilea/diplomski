public static void equalsVsSameIntegerDemo() {
    final Integer i1 = new Integer(1);
    final Integer i2 = new Integer(1);
    System.out.println(i1.equals(i2)); // true
    System.out.println(i1 == i2); // false
}