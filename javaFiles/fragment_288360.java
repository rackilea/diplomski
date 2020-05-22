public List<People> getPeopleInOrder(Comparator<People> comparator) {
    if(myList.isEmpty())
        return Collections.emptyList();

    List<People> aux = new ArrayList<>(myList);
    aux.sort(comparator);

    return aux;
}