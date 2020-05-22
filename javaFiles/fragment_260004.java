public class Util {

    public static int getFraction(Object obj, String fieldName) {
        try {
            Digits annotation = obj.getClass().getDeclaredField(fieldName).getAnnotation(Digits.class);
            return annotation.fraction();
        } catch (NoSuchFieldException | SecurityException e) {
            // BOOM!
            throw new IllegalStateException("Something went awfully wrong...", e);
        }
    }
}