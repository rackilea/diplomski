listOfObjectA = new ArrayList<>(listOfObjectA);
ObjectA previousChoice = null;

for(Predicate<ObjectA> p: props) {
    listOfObjectA.removeIf(p.negate());
    if(listOfObjectA.isEmpty()) return previousChoice;
    else {
        previousChoice = listOfObjectA.get(0);
        if(listOfObjectA.size() == 1) break;
    }
}
return previousChoice;