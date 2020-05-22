// This prelude is just to show that you don't even need to know the specific
// subclass for the type-safety argument to be relevant
Set<? extends AbstractOperation> operations = ...;
for (AbstractOperation<?> op : operations) {
    duplicate(op);
}

private <T extends AbstractOperation<T>> Collection<T> duplicate(T operation) {
    T opCopy = operation.copy();
    Collection<T> coll = new HashSet<T>();
    coll.add(operation);
    coll.add(opCopy);

    // Yeah OK, it's ignored after this, but the point was about type-safety! :)
    return coll; 
}