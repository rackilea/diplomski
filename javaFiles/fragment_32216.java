@Test
public void testMethod1() {
    int testValue = 1;      
    int expectedResult = 2;

    assertThat(testee.method1(testValue), equalTo(expectedResult));
}