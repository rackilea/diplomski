List<String> yourSingleList = new ArrayList<>();
Iterator<List<String>> lists = yourListOfLists.iterator();
while (lists.hasNext()) {
    if (!lists.next().equals(yourSingleList) {
        lists.remove();
    }
}