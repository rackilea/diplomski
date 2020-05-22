Object[] t = new Object[5];

public T getSomethingFromArray() {
    return (T)t[2];
}

public void setSomethingInArray(T something) {
    t[2] = something;
}