public class FoodInput {

    private final Food food;
    private final String input;

    public FoodInput(String input) {
        this.food = Food.fromString(input);
        this.input = input;
    }

    public Food getFood() {
        return food;
    }

    public String getInput() {
        return input;
    }
}