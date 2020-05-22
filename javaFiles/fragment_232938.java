package pagefactory.test;

import java.lang.reflect.Field;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.Annotations;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DateWidget {

    // These constants are used to identify that they should be changed to the actual IDs
    private static final String YEAR_ID = "$YEAR_ID$";
    private static final String MONTH_ID = "$MONTH_ID$";
    private static final String DAY_ID = "$DAY_ID$";

    // Elements whose ids will be replaced during run-time
    /** Year element */
    @FindBy(id = YEAR_ID)
    private WebElement year;

    /** Month element */
    @FindBy(id = MONTH_ID)
    private WebElement month;

    /** day element */
    @FindBy(id = DAY_ID)
    private WebElement day;

    // The ids of the elements
    /** ID of the year element */
    private String yearId;

    /** ID of the month element */
    private String monthId;

    /** ID of the day element */
    private String dayId;

    public DateWidget(WebDriver driver, String yearId, String monthId,
            String dayId) {
        this.yearId = yearId;
        this.monthId = monthId;
        this.dayId = dayId;

        PageFactory.initElements(new CustomLocatorFactory(driver, 15), this);
    }

    public String getYear() {
        return year.getValue();
    }

    public void setYear(String year) {
        setValue(this.year, year);
    }

    public String getMonth() {
        return month.getValue();
    }

    public void setMonth(String month) {
        setValue(this.month, month);
    }

    public String getDay() {
        return day.getValue();
    }

    public void setDay(String day) {
        setValue(this.day, day);
    }

    public void submit() {
        year.submit();
    }

    private void setValue(WebElement field, String value) {
        field.clear();
        field.sendKeys(value);
    }

    private class CustomLocatorFactory implements ElementLocatorFactory {
        private final int timeOutInSeconds;
        private WebDriver driver;

        public CustomLocatorFactory(WebDriver driver, int timeOutInSeconds) {
            this.driver = driver;
            this.timeOutInSeconds = timeOutInSeconds;
        }

        public ElementLocator createLocator(Field field) {
            return new CustomElementLocator(driver, field, timeOutInSeconds);
        }
    }

    private class CustomElementLocator implements ElementLocator {
        private WebDriver driver;
        private int timeOutInSeconds;
        private final By by;

        public CustomElementLocator(WebDriver driver, Field field,
                int timeOutInSeconds) {
            this.driver = driver;
            this.timeOutInSeconds = timeOutInSeconds;
            CustomAnnotations annotations = new CustomAnnotations(field);
            this.by = annotations.buildBy();
        }

        @Override
        public WebElement findElement() {
            ExpectedCondition<Boolean> e = new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    d.findElement(by);
                    return Boolean.TRUE;
                }
            };
            Wait<WebDriver> w = new WebDriverWait(driver, timeOutInSeconds);
            w.until(e);

            return driver.findElement(by);
        }
    }

    private class CustomAnnotations extends Annotations {

        public CustomAnnotations(Field field) {
            super(field);
        }

        @Override
        protected By buildByFromShortFindBy(FindBy findBy) {

            if (!"".equals(findBy.id())) {
                String id = findBy.id();
                if (id.contains(YEAR_ID)) {
                    id = id.replace(YEAR_ID, yearId);
                    return By.id(id);
                } else if (id.contains(MONTH_ID)) {
                    id = id.replace(MONTH_ID, monthId);
                    return By.id(id);
                } else if (id.contains(DAY_ID)) {
                    id = id.replace(DAY_ID, dayId);
                    return By.id(id);
                }
            }

            return super.buildByFromShortFindBy(findBy);
        }

    }

}