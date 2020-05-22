List<String> uniqueNames = new ArrayList<>();
List<Integer> uniquePrices = new ArrayList<>();

for (Map.Entry<String, Integer> entry : totals.entrySet()) {
    uniqueNames.add(entry.getKey());
    uniquePrices.add(entry.getValue());
}