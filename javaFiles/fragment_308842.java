MutableList<Ingredient> ingredients =
        Lists.mutable.with(
                new Ingredient("Flour"),
                new Ingredient("Sugar"),
                new Ingredient("Eggs"),
                new Ingredient("Milk"));
MutableList<String> ingredientNames = ingredients.collect(new Function<Ingredient, String>()
{
    public String valueOf(Ingredient ingredient)
    {
        return ingredient.getName();
    }
});
String delimitedNames = ingredientNames.makeString(", ");
Assert.assertEquals("Flour, Sugar, Eggs, Milk", delimitedNames);