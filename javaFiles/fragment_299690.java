@Override
public boolean equals (Object anObject)
{
    if (this == anObject)
        return true;
    if (anObject instanceof Shelf) {
        Shelf anotherShelf = (Shelf) anObject;
        return this.getShelfNumber() == anotherShelf.getShelfNumber(); // assuming this
                                                                       // is a primitive
                                                                       // (if not, use equals)
    }
    return false;
}