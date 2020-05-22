// Introduce type parameter T, upper bound itself.
class A<T extends A<T>> {
    protected T otherA;  // now of type T

    public T getOtherA() {  // now returns T
        return otherA;
    }
}