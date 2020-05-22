public static void main(String[] args) throws Exception {
    String foo = "foo";
    System.out.println("foo's hash value: " + foo.hashCode());
    Field stringValueField = String.class.getDeclaredField("value");
    stringValueField.setAccessible(true);
    stringValueField.set(foo, "bar".toCharArray());
    Field stringHashField = String.class.getDeclaredField("hash");
    stringHashField.setAccessible(true);
    stringHashField.set(foo, 0);
    System.out.println("foo's new value: " + foo);
    System.out.println("foo's new hash value: " + foo.hashCode());
}