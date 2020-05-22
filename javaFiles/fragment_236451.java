public class NormTableFactory {
    public static <E extends Enum<E>> NormTable<E> normTableForSurveyAndType(
        String surveyCode, Class<E> clazz) {
    if ("Foo".equals(surveyCode) && Subscale.class.equals(clazz)) {
        return (NormTable<E>) new FooSubscaleNormTable<E>();
    } else {
            // whatever else
        }
    }
}