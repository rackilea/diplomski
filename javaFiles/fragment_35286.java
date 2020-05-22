List<MyObject> allResults = getResults();
Iterator<DisplayItem> it = allResults.stream()
    .filter(this::someCrazyFiltering)
    .map(this::turnToDisplayItem)
    .iterator();

onClick(() -> {
    int n = 0;
    while(n < 10 && it.hasNext()){
       this.addDisplayItemToContainer(it.next());
    }
});