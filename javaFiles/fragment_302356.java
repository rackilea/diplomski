Object original = db.get(this.getDatabaseId());
T modified = this.adaptObjectToContainer(original);
...

protected T adaptObjectToContainer(Object original) {
    if(this.getValueHolderValueType().isInstance(original)) {
        return (T)original;
    }
    throw new ClassCastException(...);
}

// subclasses may do relevant conversions, throw an exception, etc
protected Interval adaptObjectToContainer(Object original) {
    ...
    if(original instanceof String) {
        return new Interval(original);
    }
    ...
}