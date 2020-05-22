@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldMatchValidator.class)
public @interface FieldMatch {

    String message() default "something is wrong!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * @return The first field
     */
    String first();

    /**
     * @return The second field
     */
    String second();

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        FieldMatch[] value();
    }

    public static class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

        private String firstFieldName;
        private String secondFieldName;

        @Override
        public void initialize(FieldMatch fieldMatch) {
            firstFieldName = fieldMatch.first();
            secondFieldName = fieldMatch.second();
        }

        public boolean isValid(Object object, ConstraintValidatorContext constraintContext) {
            try {
                final Object firstObj = getProperty(object, firstFieldName);
                final Object secondObj = getProperty(object, secondFieldName);

                if(firstObj == null && secondObj == null || firstObj != null && secondObj != null) {
                    return false;
                }
            } catch (final Exception ignore) {
                // ignore
            }
            return true;
        }

        private Object getProperty(Object value, String fieldName) {
            Field[] fields = value.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.getName().equals(fieldName)) {
                    field.setAccessible(true);
                    try {
                        return field.get(value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }
    }

}