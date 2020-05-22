@Test
    public final void testThirdValue() {

        System.out.println("retrieve");
        String factories = " BK M6B 7A4";
        Parser parser = new Parser();
        Parser province = parser.thirdValue(factories);

       assertEquals("M6B 7A4", province.getFirstValue()); 
       assertEquals("BK", province.getSecondValue());
    }