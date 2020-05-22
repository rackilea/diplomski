import org.apache.commons.lang.Validate;
import org.apache.commons.lang.StringUtils;

public class Something {
   public void doSomething(final Integer someInt, final String someString) {
       Validate.notNull(someInt, "Can't proceed when someInt is null!");
       Validate.isTrue(!StringUtils.isEmpty(someString, "Can't proceed when someString is null or empty!");
       //do stuff
   }
}