Map<Integer, Integer> sums = new HashMap<>();
for (LiveEventsDto car: cars) {
    int key = car.getProgramId();
    int count = car.getProgramPercentTotalViewed();
    if (sums.containsKey(key) {
        count += sums.get(key);
    }
    sums.put(key, count);
}