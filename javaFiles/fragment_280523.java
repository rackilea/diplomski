import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class Testpdf {

   public WebDriver driver;
   private ArrayList1 arraylist2 = new ArrayList1();
   List<String> listTestClassIndexes = new ArrayList<String>();
   PdfUtility pdfUtility = new PdfUtility();

   @Test
   public void testclass() {
      listTestClassIndexes.add(arraylist2.getList(0));
   }

   @AfterSuite
   public void tearDown() throws Exception {
      // add time stamp to the resultList
      listTestClassIndexes.add(arraylist2.getList(2));

      // write the test result pdf file with file name TestResult
      pdfUtility.WriteTestResultToPdfFile("TestResult.pdf",
            listTestClassIndexes);
      driver.quit();
    }
}