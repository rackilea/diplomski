import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.events.TestCaseEvent;
import ru.yandex.qatools.allure.model.SeverityLevel;
import ru.yandex.qatools.allure.model.TestCaseResult;

import static org.testng.Assert.assertTrue;
import static ru.yandex.qatools.allure.AllureUtils.createSeverityLabel;

public class ParameterizedTestngTest {

    @DataProvider(name = "TH_DataProvider")
    public static Object[][] dataProvider() {
        return new Object[][] {{"Minor", "Test data 1"}, {"Major", "Test data 2"}, {"Blocker", "Test data 3"}};
    }

    // @Severity(SeverityLevel.TRIVIAL) // overwriting annotation is also possible, please uncomment code in event class
    @Test(dataProvider = "TH_DataProvider", enabled = true)
    public void M01_createRelease(String sNo, String te) {
        SeverityLevel severity = SeverityLevel.TRIVIAL;

        // overwriting default severity
        if (sNo.equals("Minor")) {
            severity = SeverityLevel.MINOR;
        } else if (sNo.equals("Blocker")) {
            severity = SeverityLevel.BLOCKER;
        }
        Allure.LIFECYCLE.fire(new SetSeverityEvent(severity));

        // test
        assertTrue(true);
    }

    public static class SetSeverityEvent implements TestCaseEvent{

        private SeverityLevel severity;

        public SetSeverityEvent(SeverityLevel severity) {
            this.severity = severity;
        }

        @Override
        public void process(TestCaseResult context) {
            context.withSeverity(severity);

            // you can additionally remove severity label im case you use @Severity annotation as your default severity
//            context.setLabels(Lists.newArrayList(Collections2.filter(context.getLabels(), new Predicate<Label>() {
//                @Override
//                public boolean apply(Label label) {
//                    return !label.getName().equals(LabelName.SEVERITY);
//                }
//            })));
        }
    }

}