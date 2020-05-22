public class Meal {

    private List<FoodQuantity> elements = new ArrayList<>();

    public addFood(Food food, int grams) {
        elements.add(new FoodQuantity(food, grams));
    }

    ...
}