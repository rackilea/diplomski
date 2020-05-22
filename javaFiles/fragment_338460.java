@RunWith(Parameterized.class)
@UseParametersRunnerFactory(CucumberRunnerFactory.class)
public class CucumberStepDefs extends CoopeuchAutomatedWebTest {

    public static class CucumberRunnerFactor
            implements ParameterizedRunnerFactory {

        public Runner createRunnerForTestWithParameters(
            TestWithParameters test
        ) throws InitializationError {
            try {
                return Cucumber(test.getTestClass().getJavaClass());
            } catch (IOException e) {
                throw new InitializationError(e);
            }
        }
    }

    @Parameterized.Parameters
    public static Object[] data() {
        return SetDatos.getInstance().getData(CucumberStepDefs.class);
    }

    @Parameterized.Parameter(value = 0)
    public String usuario;

    ...
}