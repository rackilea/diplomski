public List<SetOfStuff.ID> extractIds(List<SetOfStuff> stuffList) {
    List<SetOfStuff.ID> ids = new ArrayList<>() // Java 7.
    for((SetOfStuff stuff: stuffList) {
        ids.add(stuff.getId());
   }
    return ids;
}