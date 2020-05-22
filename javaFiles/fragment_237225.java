@Controller
public class InitController {

@Inject
public InitController(TestDao testDao, InsynctivePropertyDao propertyDao, ServletContext servletContext, AccountDao accDao, CrossBrowserAccountDao crossDao, CreatePersonFormDao createPersonFormDao, TestSuiteDao testSuiteDao) {
    HibernateUtil.init(testDao, propertyDao, servletContext, accDao, crossDao, createPersonFormDao, testSuiteDao);
}
}