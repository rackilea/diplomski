private int getNextId(Food food, int id) {
    if (food.getType().equals(REPLACE)) {
        int n = food.getIds().length;
        for (int i = 0; i < n; i++) {
            if (food.getIds()[i] == id && (i+1) < n) {
                return food.getIds()[i + 1];
            }
        }
    }
    return -1;
}