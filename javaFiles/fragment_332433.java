List<String> yourSingleList = new ArrayList<>();
for (List<String> list : yourListOfLists) {
    //remove entries
    list.retainAll(yourSingleList);
    //or remove matching entities
    list.removeAll(yourSingleList);
}