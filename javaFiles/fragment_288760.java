class FirstNonRepeatingCharacterStreamTest3 {

    private static FirstNonRepeatingCharacterStream tester;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        tester = new FirstNonRepeatingCharacterStream();
    }

    @DisplayName("MyTest")
    @ParameterizedTest(name = "{index} => input={0}, output= {1}")
    @CsvSource({
        "'a', 'a'",
        "'b', 'a'",
        "'a', 'b'",
        "'c', 'b'",
        "'b', 'c'",
        "'a', 'c'",
        "'d', 'c'"
    })
    public void testFirstNonRepeatingCharStream101(Character input, Character output) {
        Character actual = tester.firstNonRepeatingCharStream1(input);
        assertEquals(output, actual);
    }
}