@Test
public void getFormattedValue() {
    List<String> data = Arrays.asList("operation", "foo", "bar");
    List<String> dataHeaders;
    String formated;

    dataHeaders = Arrays.asList("OPERATION_NAME", "FOO_NAME", "BAR_NAME");
    formated = getFormattedValue(dataHeaders, data);
    Assert.assertEquals("operation", formated); // no spaces

    dataHeaders = Arrays.asList("FOO_NAME", "OPERATION_NAME", "BAR_NAME");
    formated = getFormattedValue(dataHeaders, data);
    Assert.assertEquals("foo    ", formated); // four spaces

    dataHeaders = Arrays.asList("FOO_NAME", "BAR_NAME", "OPERATION_NAME");
    formated = getFormattedValue(dataHeaders, data);
    Assert.assertEquals("bar      ", formated); // six spaces

    dataHeaders = Arrays.asList("FOO_NAME", "BAR_NAME", "", "", "", "", "",
             "", "", "OPERATION_NAME");
    data = Arrays.asList("operation", "foo", "bar", "", "", "", "", 
            "", "", "tail");
    formated = getFormattedValue(dataHeaders, data);
    // ----format for 10----
    Assert.assertEquals("tail----format for 10----", formated); 
}