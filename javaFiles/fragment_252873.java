public class OneOfValidator implements ConstraintValidator<OneOf, Object> {

    private String[] fields;
    private String fieldList;

    public void initialize(OneOf annotation) {
        this.fields = annotation.value();
        fieldList = Arrays.toString(fields);
    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {

        BeanWrapper wrapper = PropertyAccessorFactory.forBeanPropertyAccess(value);
        int matches = countNumberOfMatches(wrapper);
        if (matches > 1) {
            setErrorMessage(context, <your message>);
            return false;
        } else if (matches == 0) {
            setErrorMessage(context, <your message>);
            return false;
        }

        return true;
    }

    private int countNumberOfMatches(BeanWrapper wrapper) {
        int matches = 0;
        for (String field : fields) {
            Object value = wrapper.getPropertyValue(field);
            boolean isPresent = detectOptionalValue(value);

            if (value != null && isPresent) {
                matches++;
            }
        }
        return matches;
    }

    private boolean detectOptionalValue(Object value) {
        if (value instanceof Optional) {
            return ((Optional)value).isPresent();
        }
        if (value instanceof String) {
            return StringUtils.hasText((String)value);
        }
        return true;
    }
    private void setErrorMessage(ConstraintValidatorContext context, String template) {
        context.disableDefaultConstraintViolation();
        context
                .buildConstraintViolationWithTemplate(template)
                .addNode(fieldList)
                .addConstraintViolation();
    }