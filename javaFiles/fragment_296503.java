public ArrayInObj(int max) {
    /* this gets implicitly added and fails to compile */
    super();
    a = new Person[max];
    nElems = 0;
}