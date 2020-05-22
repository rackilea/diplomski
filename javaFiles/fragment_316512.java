@Test
public void testConvertTwoDigitYearWithWrongInput() {
    WeekConverter weekConverter = new WeekConverter(WeekConverter.Strategy.TWO_DIGIT_YEAR); 

    assertFailsToConvert(weekConverter, ""); 
    assertFailsToConvert(weekConverter, "abcdefgh");
}

private void assertFailsToConvert(WeekConverter weekConverter, String input) {
    try {
        weekConverter.convert(input);
        fail("Should not convert [" + input + "]");
    } catch (IllegalArgumentException ex) {}
}