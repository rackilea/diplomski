public class NestedGeneric<T> {
    private InnerGeneric<T> innerGenericInstance;

    private static class InnerGeneric<U> {
        private U innerGenericField;
    }

    NestedGeneric() {
        innerGenericInstance = new InnerGeneric<T>();
    }
}