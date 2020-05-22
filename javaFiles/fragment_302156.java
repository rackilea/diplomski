static ObjectB get(List<ObjectB> list, ObjectA oA) {
    return get(list,
        oB -> oA.getProp1().equals(oB.getProp1()),
        oB -> oA.getProp2().equals(oB.getProp2()),
        oB -> oA.getProp3().equals(oB.getProp3()));
}
static ObjectA get(List<ObjectA> list, ObjectB oB) {
    return get(list,
        oA -> oB.getProp1().equals(oA.getProp1()),
        oA -> oB.getProp2().equals(oA.getProp2()),
        oA -> oB.getProp3().equals(oA.getProp3()));
}
static <T> T get(List<T> listOfT, Predicate<T>... props) {
    listOfT = new ArrayList<>(listOfT);
    T previousChoice = null;

    for(Predicate<T> p: props) {
        listOfT.removeIf(p.negate());
        if(listOfT.isEmpty()) return previousChoice;
        else {
            previousChoice = listOfT.get(0);
            if(listOfT.size() == 1) break;
        }
    }
    return previousChoice;
}