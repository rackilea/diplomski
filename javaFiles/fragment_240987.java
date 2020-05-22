public class FooTest {

   private static Validator validator;

   @BeforeClass
   public static void setUp() {
      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
      validator = factory.getValidator();
   }

   @Test
   public void checkIfIsNull() {
      Foo foo = new Foo(); // Field is null at this point

      Set<ConstraintViolation<Car>> constraintViolations = validator.validate(foo);

      assertTrue(constraintViolations.size() > 0);
   }
}