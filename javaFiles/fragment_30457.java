@Property
private int indexProp;

@Property
private SomeObject result;

public void setCurrentAction(String action) {
    result.actions.set(indexProp);
}

public String getCurrentAction() {
    return result.actions.get(indexProp);
}