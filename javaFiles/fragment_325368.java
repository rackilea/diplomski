@Test
public void higher_should_return_number_plus_1() {
    int result = getValue("higher", 10);
    Assert.assertEquals(11, result); // simple assertions
}

@Test
public void garbage_should_return_same_number() {
    int result = getValue("Hello, Polly!", 10);
    Assert.assertEquals(10, result); // simple assertions
}