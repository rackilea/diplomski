@Override
    public void getRecipesFromAPI(final RecipeGetAllListener recipeGetAllListener) {
        subscription = recipesAPI.getAllRecipes()
                                 .subscribeOn(schedulersProvider.getWorkerScheduler())
                                 .observeOn(schedulersProvider.getUiScheduler())
                                 ...
    }