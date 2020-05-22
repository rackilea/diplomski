import static org.junit.Assert.assertEquals;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Test;

public class UserTest {

    @Test
    public void test() {
    User user = new User();
    // set name over 10
    user.setName("12345678912");

    // validate the input
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<User>> violations = validator.validate(user);
    for (ConstraintViolation v : violations) {
        String key = "";
        if (v.getPropertyPath() != null) {
        key = v.getPropertyPath().toString();
        assertEquals("name", key);
        assertEquals("size must be between 0 and 10", v.getMessage());
        }

    }
    assertEquals(1, violations.size());
    }

}