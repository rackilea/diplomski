ExecutorService executor = Executors.newFixedThreadPool(list.size() / 100 + 1);
// (+1 in case there are less than 100 items)
for (int i = 0; i < list.size(); i += 100) {
    final int start = i;
    executor.execute(() -> {
        int end = start + 100;
        if (end > list.size()) {
            end = list.size();
        }
        for (int j = start; j < end; ++j) {
            list.get(j).doYourLogicHere();
        }
    });
}