import org.junit.Test;
import org.springframework.context.ApplicationContext;

public class MovedDtdTest {

  @Test
  public void test()throws Exception {
    ApplicationContext context = new FileSystemXmlApplicationContext("classpath:test.xml");
  }
}