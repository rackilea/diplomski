public class ReadCSVJUnitParametrized {

    @ParameterizedTest
    @CsvFileSource(resources = "/financial.csv", numLinesToSkip = 1)
    public void testLetterCountParametrized(String value, long letterCount) {
        assertEquals(letterCount, LetterCounter.countLetters(value));
    }
}