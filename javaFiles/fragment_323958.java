class A {
    private final ObjectProperty<X> objx = new SimpleObjectProperty<>();

    public ObjectProperty<X> objxProperty() {
        return objx ;
    }

    public final X getObjx() {
        return objxProperty().get();
    }

    public final void setObjx(X objx) {
        objxProperty().set(objx);
    }
}