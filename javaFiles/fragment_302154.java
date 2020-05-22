List<Predicate<ObjectA>> props = Arrays.asList(
    oA -> oB.getProp1().equals(oA.getProp1()),
    oA -> oB.getProp2().equals(oA.getProp2()),
    oA -> oB.getProp3().equals(oA.getProp3()));

ObjectA previousChoice = null;

for(Predicate<ObjectA> p: props) {
    listOfObjectA = listOfObjectA.stream().filter(p).collect(Collectors.toList());
    if(listOfObjectA.isEmpty()) return previousChoice;
    else {
        previousChoice = listOfObjectA.get(0);
        if(listOfObjectA.size() == 1) break;
    }
}
return previousChoice;