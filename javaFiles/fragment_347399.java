public static void println(String s) {
    System.out.println(s);
  }

  @Test
  public void testNullStripWithEmptyString() {
    String input = "foo" + '\0';
    String input2 = "foo";
    println(input);
    println("input:");
    printBytes(input.getBytes());
    println("input2:");
    printBytes(input2.getBytes());
    String testValue = input.replaceAll("", "");
    println("testValue:");
    printBytes(testValue.getBytes());
    String testvalue2 = input2.replaceAll("","");
    println("testvalue2");
    printBytes(testvalue2.getBytes());
    assertFalse(input.equals(input2));
    assertFalse(testValue.equals(testvalue2));
  }