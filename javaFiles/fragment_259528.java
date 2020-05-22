private Calculator mCalculatorInstance;

@Before
public void setupTestEnvironment() {
    // This method will be call before every single test.
    mCalculatorInstance = new Calculator(2.0);
}

@Test
public void testAdd(){
    mCalculatorInstance.add(2.0); // add 2 to the initial value of 2 which I instanitiate above should return 4.
    assertEquals("Adding 2 to 2 should give me 4.", 4.0, c.getAccumulator());
}