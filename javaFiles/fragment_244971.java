enum Ingredients {
    APPLE,
    BANANA,
    FLOUR,
    SUGAR;

    static{
        APPLE.setRecipes(Arrays.asList(Recipes.APPLE_FRITTER));
        BANANA.setRecipes(Arrays.asList(Recipes.BANANA_FRITTER));
        FLOUR.setRecipes(Arrays.asList(Recipes.APPLE_FRITTER, Recipes.BANANA_FRITTER));
        SUGAR.setRecipes(Arrays.asList(Recipes.APPLE_FRITTER, Recipes.BANANA_FRITTER));
    }

    List<Recipes> recipes;

    private void setRecipes(List<Recipes> products){
        this.recipes = products;
    }

}

enum Recipes {
    APPLE_FRITTER,
    BANANA_FRITTER;

    static{
        APPLE_FRITTER.setIngredients(Arrays.asList(Ingredients.APPLE, Ingredients.FLOUR, Ingredients.SUGAR));
        BANANA_FRITTER.setIngredients(Arrays.asList(Ingredients.BANANA, Ingredients.FLOUR, Ingredients.SUGAR));
    }

    List<Ingredients> ingredients;

    private void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

}