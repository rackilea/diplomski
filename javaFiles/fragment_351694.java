import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@ContextConfiguration(classes = { TenantTest.Config.class })
@RunWith(SpringRunner.class)
public class TenantTest {

    @Autowired
    private DecisionDao decisionDao;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testCreateDecisionUsingAssertj() {
        assertThatExceptionOfType(ConstraintViolationException.class)
                .isThrownBy(
                        () -> decisionDao.create(null,
                                "Root decision 1 description", null, null));
    }

    @Test
    public void testCreateDecision() {
       expectedException.expect(ConstraintViolationException.class);
       decisionDao.create(null, "Root decision 1 description", null, null);
    }

    @Configuration
    public static class Config {
        @Bean
        public MethodValidationPostProcessor methodValidationPostProcessor() {
            return new MethodValidationPostProcessor();
        }

        @Bean
        public DecisionDao decisionDao() {
            return new DecisionDaoImpl();
        }
    }
}