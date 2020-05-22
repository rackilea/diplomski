import java.io.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class palindromeStringTest {

  ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  static String desc;

  //public method to get the value of desc
  public function getDescription(){
    return desc;
  }

  @Before
  public void setUpStream() {
    System.setOut(new PrintStream(outContent));
  }

  @After
  public void cleanUpStream() {
    System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
  }

  @Test
  public void revTest() {
    palindromeStringTest.desc = "this should reverse the string";
    String a = "Madam";
    palindromeString obj = new palindromeString();
    String b = obj.rev(a);
    assertEquals("madaM", b);
  }
}