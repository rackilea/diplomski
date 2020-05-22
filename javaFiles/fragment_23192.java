import org.junit.Assert;
import org.junit.Test;

public class YourTestClass{
  @Test
  public void testBasic() {
    System.out.println("testBasic() START");

    Assert.assertTrue(true); // pass
    Assert.assertFalse(true); // fail

    System.out.println("testBasic() END");

  }
}