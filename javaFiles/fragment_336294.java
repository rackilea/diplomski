for (Iterator<YourClass> it = yourCollection.iterator(); it.hasNext(); ) {
    YourClass yourClass = it.next();
    //do whatever...
    //and looks like you change yourClass value here
    //which is a local variable, not the real object reference inside your collection

    //also, you cannot add/remove an element here to the collection being iterated
    //because this will throw a ConcurrentModificationException
}