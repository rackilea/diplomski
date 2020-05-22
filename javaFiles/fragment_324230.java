public void castGenericReturnType() {
    System.out.println(this.<Integer>genericReturn(1));
    System.out.println((Integer) genericReturn(1));
}

public <I> I genericReturn(Object objectToCast) {
    return (I) objectToCast;
}