public void addIndividualsOfType(Class<? extends Individual> clazz){
    for (ListIterator it = indiList.listIterator(); it.hasNext(); ){
        it.next()
        it.add(clazz.newInstance());  // using no-args constructor
    }
}