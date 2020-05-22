@Test 
  public void testNullStripWithNullUnicodeEscape(){
    String input = "foo" + '\0';
    String input2 = "foo";
    println(input);
    println("input:");
    printBytes(input.getBytes());
    println("input2:");
    printBytes(input2.getBytes());
    String testValue = input.replaceAll("\u0000", "");
    println("testValue:");
    printBytes(testValue.getBytes());
    String testvalue2 = input2.replaceAll("\u0000","");
    println("testvalue2");
    printBytes(testvalue2.getBytes());
    assertFalse(input.equals(input2));
    assertTrue(testValue.equals(testvalue2));
  }