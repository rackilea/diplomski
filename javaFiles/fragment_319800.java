public void addChild(Child child) {
    children.add(child);
    child.setParent(this);
}

public void removeChild(Child child) {
    children.remove(child);
    child.setParent(null);
}