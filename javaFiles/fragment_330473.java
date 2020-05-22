import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

public class SomeTest {

    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Cat a = new Cat(null);
        // invalid: name is null
        output(validator.validate(a), a);

        Cat b = new Cat("?");
        // invalid: name too short
        output(validator.validate(b), b);

        // valid: only @NotNull is evaluated, @Size does not matter.
        output(validator.validate(b, NotNullName.class), b);

        // invalid: only @NotNull is evaluated, @Size does not matter. Name is null.
        output(validator.validate(a, NotNullName.class), a);
    }

    /**
     * Output validation result.
     *
     * @param validate
     *            the validate
     */
    private static void output(Set<ConstraintViolation<Cat>> validationResult, Cat cat) {
        if (validationResult.isEmpty()) {
            System.out.println(cat + " is valid!");
        } else {
            System.out.println(cat + " is invalid!\n" + validationResult);
        }
    }

    // no need to implement an interface - just name it for annotation groups attribute:
    public static class Cat {
        @NotNull(groups = { NotNullName.class, Default.class })
        @Size(min = 3, max = 45)
        private String name;

        public Cat(String name) {
            super();
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Cat [");
            if (name != null) {
                builder.append("name=");
                builder.append(name);
            }
            builder.append("]");
            return builder.toString();
        }

    }

    public static interface NotNullName {
        // no members needed here
    }
}