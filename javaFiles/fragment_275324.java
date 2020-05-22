ArrayList<ArrayList<Food>> result = new ArrayList<>();
ArrayList<Food> subArray = new ArrayList<>();
for (int i = 0; i < foods.length; i++) {
    subArray.add(foods[i]);
    if (i % 3 == 2) {
        result.add(subArray);
        subArray = new ArrayList<>();
    }
}