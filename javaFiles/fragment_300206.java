Iterator it = list.iterator();
while (it.hasNext()) {
    Object thing = it.next();
    if (ThisIsTheObjectWeAreLookingFor(thing)) {
        it.remove();
        list.addFirst(thing);
        return thing;
    }
}