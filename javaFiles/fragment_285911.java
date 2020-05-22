import java.util.ArrayList;
import java.util.List;

public class Ingredients {

List<Ingredient> ingredients;

public Ingredients() {

    this.ingredients = new ArrayList<Ingredient>();

}

public void addIngredient(Ingredient ingredient) {

    ingredients.add(ingredient);
}

public void showIngredients() {
    for (Ingredient ingredientI : ingredients) {
        System.out.println(ingredientI.getIngredientName() + " " + ingredientI.getIngriedientQuantity());
    }

}

}