for (AbstractThing thing : yourCollection) {
    if (thing instanceof SubclassWithSpecialMethod) {
        ((SubclassWithSpecialMethod)thing).specialMethod();
    }
    else {
        thing.method();
    }
}