// Java
public fj.data.Option<Integer> getMyField() {
    return fj.data.Option.fromNull(myField);
}

public void setMyField(fj.data.Option<Integer> value) {
    myField = value.toNull();
}