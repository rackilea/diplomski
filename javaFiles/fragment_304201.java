static class SomeClass {
  SomeClass(long... value) { System.out.println("Long"); }
  SomeClass(int... value) { System.out.println("Int"); }
  SomeClass(byte... value) { System.out.println("Byte"); }
}

public static void main(String[] args) throws Exception {
  SomeClass o = new SomeClass(); // Byte
}