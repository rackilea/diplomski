class A {

    private final ReadOnlyObjectWrapper<X> objx = new ReadOnlyObjectWrapper<>();

    public ReadOnlyObjectProperty<X> objxProperty() {
        return objx.getReadOnlyProperty();
    }

    public final X getObjx() {
        return objxProperty().get();
    }

}