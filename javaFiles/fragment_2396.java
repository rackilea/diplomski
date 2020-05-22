@RunWith(JUnitParamsRunner.class)
public class ReadCSVJunitParamsTest {

    @Test
    @FileParameters(value = "classpath:financial.csv", mapper = CsvWithHeaderMapper.class)
    public void testLetterCount(String value, long letterCount) {
        assertEquals(letterCount, LetterCounter.countLetters(value));
    }
}