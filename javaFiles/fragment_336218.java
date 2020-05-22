public class MockDatabase<T> {
    private static final ClassValue<MockDatabase> cache = new ClassValue<>() {
         protected MockDatabase computerValue(Class<?> clazz) {
             return new MockDatabase();
         }
    }
    public static <T> MockDatabase<T> getInstance(Class<T> clazz) {
        return (MockDatabase<T>) cache.get(clazz);
    }
}