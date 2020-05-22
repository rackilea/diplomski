@Override
public Object getValue(String name) {
    if (!this.uriVariables.containsKey(name)) {
        throw new IllegalArgumentException("Map has no value for '" + name + "'");
    }
    return this.uriVariables.get(name);
}