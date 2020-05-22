// direct method reference wrapped into a weak ref later:
private final ListChangeListener<String> listener = new Foo();

public void init() {
    list.addListener(new WeakListChangeListener<String>(listener));
}