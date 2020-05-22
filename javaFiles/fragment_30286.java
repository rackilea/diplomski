public interface IndividualFactory {
    public Individual create(T1 p1, T2 p2, T3 p3);
}

public static final IndividualFactory TALL_FACTORY = new IndividualFactory() {
    public Individual create(T1 p1, T2 p2, T3 p3) {
        return new TallIndividual(p1, p2, p3);
    }
};

public void addIndividualsOfType(IndividualFactory factory){
    for (ListIterator it = indiList.listIterator(); it.hasNext(); ){
        it.next()
        it.add(factory.create(param1, param2, param3);
    }
}