public float getInventoryValue() {
    int total = productList.size();
    float sum = 0.0f;

    for(int i = 0; i < total; ++i) {
        // simple, easy loop
        sum += productList.get(i).getPrice();
    }

    return sum;
}