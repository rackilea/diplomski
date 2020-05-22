static final boolean CREATE_NEW_CLASSES = Boolean.getBoolean("generateNewClassForAndThen");

@SuppressWarnings("unchecked")
public static <A,B,C> Function<A,C> newCombinator(
    Function<? super A,? extends B> f1, Function<? super B,? extends C> f2) {

    Objects.requireNonNull(f1);
    Objects.requireNonNull(f2);

    if(!CREATE_NEW_CLASSES) return new FunctionCombinator<>(f1, f2);

    URL u = FunctionCombinator.class.getProtectionDomain().getCodeSource().getLocation();
    try(URLClassLoader cl = new URLClassLoader(new URL[] { u }, null)) {
        return cl.loadClass(FunctionCombinator.class.getName()).asSubclass(Function.class)
            .getConstructor(Function.class, Function.class)
            .newInstance(f1, f2);
    }
    catch(IOException | ReflectiveOperationException ex) {
        throw new IllegalStateException(ex);
    }
}