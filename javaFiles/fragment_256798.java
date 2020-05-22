import static org.junit.Assert.*;    

public class CalculatorTest {

  @Test
  public void testZero() 
  {   
    Calculator test = new Calculator();
    test.zero();
    assertEquals(0,test.getAcc());
  }
}