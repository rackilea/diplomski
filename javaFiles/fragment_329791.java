static void change(ArrayList arr, int amount) {
    int value;
    for(int i = 0; i < arr.size(); ++i) {
        value = (Integer) arr.get(i); // explicit casting here. Yuck!
        arr.set(i, value + amount);
    }
}