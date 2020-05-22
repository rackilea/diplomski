import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class CustomerValidationTest {

    private Validator validator;

    @Before
    public void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void whenNotEmptyPassword_thenNoConstraintViolations() {
        Customer customer = new Customer();
        customer.setPassword("");
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);

        assertThat(violations.size()).isEqualTo(1);
    }
}