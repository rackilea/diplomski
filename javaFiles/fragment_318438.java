import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ProgrammingProject4Test {

  @Test
  public void testFindMaxNumFirst() {
    // Arrange
    ProgrammingProject4 programmingProject4 = new ProgrammingProject4();

    // Act and Assert
    assertEquals("First number should be bigger than second",2, programmingProject4.findMaxNum(1,2));
  }

  @Test
  public void testFindMaxNumSecond() {
    // Arrange
    ProgrammingProject4 programmingProject4 = new ProgrammingProject4();

    // Act and Assert
    assertEquals("Second number should be bigger,2, programmingProject4.findMaxNum(2,1));
  }
}