@Test
public void testSetNZero() {
    Amdahl calculator = new Amdahl();
    try{
        calculator.setN(0);
        fail();
    } catch(IllegalArgumentException e){}
}