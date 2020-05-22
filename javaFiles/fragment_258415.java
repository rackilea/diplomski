@Property
private SomeType currentObject;

public String getClientId() {
    return "mycheckbox_" + currentObject.getId();
}

// if this returns null, tapestry won't render the attribute
public String getChecked() {
    return currentObject.isSelected() ? "checked" : null;
}