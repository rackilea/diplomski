import java.util.List;
import org.testng.IAlterSuiteListener;
import org.testng.ITestContext;
import org.testng.TestListenerAdapter;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlGroups;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class MultiRunner extends TestListenerAdapter implements IAlterSuiteListener {

  @Override
  public void alter(List<XmlSuite> suites) {
    XmlSuite xmlsuite = suites.get(0);
    XmlTest xmltest = xmlsuite.getTests().get(0);
    XmlGroups xmlgroups = xmltest.getXmlGroups();
    List<XmlClass> xmlclasses = xmltest.getClasses();
    int iteration = Integer.parseInt(System.getProperty("iterations", "2"));
    String name = xmltest.getName();
    for (int i=1; i<= iteration; i++) {
      XmlTest test = new XmlTest(xmlsuite);
      test.setName(name + "_" + i);
      test.setGroups(xmlgroups);
      test.setXmlClasses(xmlclasses);
    }
  }

  @Override
  public void onStart(ITestContext testContext) {
    System.err.println("Commencing execution of [" + testContext.getName() + "]");
  }
}