Object ref = new Object() {
    public void method() {
        System.out.println("hidden");
    }
};
Class<?> anonymousClass = ref.getClass();
Method method = anonymousClass.getMethod("method");
method.invoke(ref, new Object[0]);