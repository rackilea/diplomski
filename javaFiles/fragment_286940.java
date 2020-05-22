public final class IngredientQuantity {

    public static enum QuantityUnit {
        // Add other unit types here.
        PIECE, MILLILITRE, GRAMME
    }

    private final Ingredient ingredient;
    private final QuantityUnit unit;
    private final double quantity;

    public IngredientQuantity(Ingredient ingredient, QuantityUnit unit,
            double quantity) {
        this.ingredient = Objects.requireNonNull(ingredient);
        this.unit = Objects.requireNonNull(unit);
        this.quantity = quantity;
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
    }   
}