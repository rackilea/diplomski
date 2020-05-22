private char        name[];

public final void setName(String name) {
    checkAccess();
    this.name = name.toCharArray();
}

public final String getName() {
    return String.valueOf(name);
}