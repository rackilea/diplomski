abstract class App<E> {
    protected final Class<E> extType;
    protected final Map<Class<? extends E>, List<E>> extensions;

    protected App(Class<E> extType) {
        this.extType    = extType;
        this.extensions = loadExtensions(extType);
    }
}