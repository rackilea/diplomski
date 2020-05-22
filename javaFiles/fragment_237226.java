public class HibernateUtil {

public static CrossBrowserAccountDao crossDao;
public static TestDao testDao;

public static synchronized void init(TestDao testDao, InsynctivePropertyDao propertyDao, ServletContext servletContext, AccountDao accDao, CrossBrowserAccountDao crossDao, CreatePersonFormDao createPersonFormDao, TestSuiteDao testSuiteDao){
    HibernateUtil.crossDao = crossDao;
    HibernateUtil.testDao = testDao;
}
}