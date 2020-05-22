private static final List<Recipe> TEST_RECIPES = new ArrayList<Recipe>() {
        {
            add(new Recipe(1)),
            add(new Recipe(2))
        }
    };

    @Test
    public void testGetRecipesFromAPI() {
        when(recipeAPI.getAllRecipes())
            .thenReturn(Observable.fromIterable(TEST_RECIPES));

        recipeListModel.getRecipesFromAPI(recipeGetAllListener);

        // verifying, that `recipeAPI.getAllRecipes()` has been called once
        verify(recipeAPI).getAllRecipes();

        // verifying, that we received correct result
        verify(recipeGetAllListener).onRecipeGetAllSuccess(TEST_RECIPES);
    }