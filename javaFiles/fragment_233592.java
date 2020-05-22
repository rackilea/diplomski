private ObjectProperty<T> x = new SimpleObjectProperty<>();

public ObjectProperty<T> xProperty() {
    return x ;
}
public final T getX() {
    return x.get();
}
public final void setX(T x) {
    this.x.set(x);
}