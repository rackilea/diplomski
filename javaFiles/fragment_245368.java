public class Test {

    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    @ConstraintComposition(CompositionType.AND)
    @Min(value = 0)
    @Max(value = 0)
    @Target( { ElementType.ANNOTATION_TYPE } )
    @Retention( RetentionPolicy.RUNTIME )
    @Constraint(validatedBy = { })
    public @interface ZeroComposite {
        String message() default "Not valid";
        Class<?>[] groups() default { };
        Class< ? extends Payload>[] payload() default { };
    }

    @ConstraintComposition(CompositionType.OR)
    @Null
    @ZeroComposite
    @Range(min=15, max = 80)
    @Target( { ElementType.METHOD, ElementType.FIELD } )
    @Retention( RetentionPolicy.RUNTIME )
    @Constraint(validatedBy = { })
    public @interface Composite {
        String message() default "Not valid";
        Class<?>[] groups() default { };
        Class< ? extends Payload>[] payload() default { };
    }

    @Composite
    private Integer age;


    public Test(Integer age) {
        this.age = age;
    }

    public static void main(String args[]) {
        validate(new Test(-1));
        validate(new Test(null));
        validate(new Test(0));
        validate(new Test(5));
        validate(new Test(15));
        validate(new Test(80));
        validate(new Test(81));
    }

    private static void validate(Test t) {
        Set<ConstraintViolation<Test>> violations = 
            factory.getValidator().validate(t);

        for (ConstraintViolation<Test> cv : violations) {
            System.out.println(cv.toString());
        }
    }
}