public class GroupValidationTest {


    public static void main(String[] args) {
        Validator v = Validators.newValidator();


        Model m = new Model();
        m.user = "Harry";
        m.password = "Potter";

        Set<ConstraintViolation<Model>> validate = v.validate(m, INPUT.class);
        System.out.println(validate.size());

        validate = v.validate(m, INPUT.class, OUTPUT.class);
        System.out.println(validate.size());

        validate = v.validate(m, OUTPUT.class);
        System.out.println(validate.size());

        m.password = null;

        validate = v.validate(m, INPUT.class, OUTPUT.class);
        System.out.println(validate.size());

        validate = v.validate(m, OUTPUT.class);
        System.out.println(validate.size());
    }

    public static class Model {

        @NotEmpty(groups={INPUT.class, OUTPUT.class})
        public String user;

        @NotEmpty(groups={INPUT.class})
        public String password;

    }

    public interface INPUT {}
    public interface OUTPUT {}

}