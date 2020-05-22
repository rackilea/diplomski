TargetObject build() {
    TargetObject res = new TargetObject();
    res.setProperty1();
    res.setProperty2();
    if (...) {
        throw new IllegalStateException();
    }
    return res;
}