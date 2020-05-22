public ArrayList<Food> generateFoods() {

    ArrayList<Food> foodList = new ArrayList<Food>();

    String[] foods = {"Service: Bag  \'n\'  Cut", "Service: Mulch Thrown", "Service: Grass Seed", "Service: Spring Decoration", "Service: Snow Plow" };
    String[] costs = {"150", "150", "150", "150", "150"};

    for (int i = 0; i < foods.length; i++) {
        Food food = new Food();
        food.name = foods[i];
        food.cost = costs[i];
        foodList.add(food);
    }

    return foodList;
}