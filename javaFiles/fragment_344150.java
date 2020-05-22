@Retention(RetentionPolicy.RUNTIME)
public @interface X {
    String[] value();
}

@X({"a", "b", "c"})
interface AnInterface {}

public static class TestClass implements AnInterface {}

public static void main(String[] args) {
    // annotations are not inherited, empty array
    System.out.println(Arrays.toString(TestClass.class.getAnnotations()));

    // check if TestClass is annotated with X and get X.value()
    Arrays.stream(TestClass.class.getAnnotatedInterfaces())
            .filter(type -> type.getType().equals(AnInterface.class))
            .map(type -> (Class<AnInterface>) type.getType())
            .findFirst()
            .ifPresent(anInterface -> {
                String[] value = anInterface.getAnnotation(X.class).value();
                System.out.println(Arrays.toString(value));
            });
}