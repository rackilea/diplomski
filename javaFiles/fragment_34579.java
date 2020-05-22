public boolean isDescendantOf(String parentName) { // part of SomeClass
    SomeClass parent = this.parent;
    while (!parent.id.equals("none")) { // or null check
        if (parent.id.equals(parentName)) {
            return true; // found a parent named parentName
        }
    }
    return false; // eventually reached a parentless parent and never found one matching parentName
}