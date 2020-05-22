import lombok.Data;

@Data
public class ShoppingList {

    private final Map<FoodItem, Long> ingredientWeights = new HashMap<>();

    public void addWeight(Ingredient ingredient) {
        FoodItem foodItem = ingredient.getFoodItem();
        Long weight = ingredientWeights.getOrDefault(foodItem, 0L);
        weight += ingredient.getWeight();
        ingredientWeights.put(foodItem, weight);
    }
}