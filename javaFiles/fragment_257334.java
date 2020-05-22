public class AllStringsRegexValidator implements ConstraintValidator<AllStringsRegex, Object> {
    private Pattern pattern = null;

    @Override
    public void initialize(AllStringsRegex annotation) {
        pattern = Pattern.compile(annotation.value());
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext ctx) {
        for (Field f : object.getClass().getDeclaredFields()) {
            if (f.getType().equals(String.class)) {
                try {
                    f.setAccessible(true);
                    String value = (String)f.get(object);
                    if (!pattern.matcher(value).find()) {
                        return false;
                    }
                }
                catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}