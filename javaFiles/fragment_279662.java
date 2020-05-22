TargetObject build() {
    TargetObject res = new TargetObject();
    res.setProperty1();
    res.setProperty2();
    validate(res); // This call may throw an exception
    return res;
}

void validate(TargetObject obj) {
    if (...) {
        throw new IllegalStateException();
    }
}