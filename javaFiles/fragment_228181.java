for (Iterator<Thing> it = list.iterator(); it.hasNext(); ) {
    Thing t = it.next();
    if (shouldBeDeleted(thing) {
        it.remove();
    }
}