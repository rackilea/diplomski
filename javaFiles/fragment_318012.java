@Test
    public void recipeIntegrationTest(){
        Recipe recipe = new Recipe("Integration Test Recipe");

        //Add Instructions
        LinkedHashSet<String> instructions = new LinkedHashSet<String>();
        instructions.add("This is an instruction.");

        recipe.setRecipeSteps(instructions);


  //get the persisted recipe
 recipe =    recipeDao.add(recipe);

        Ingredient cookingOil = new Ingredient("Cooking Oil");
        ingredientDao.add(cookingOil);

        //Create IngredientInstances
        IngredientInstance iCookingOil = new IngredientInstance("1/8 cup", cookingOil);
        iCookingOil.setRecipe(recipe);
        ingredientInstanceDao.add(iCookingOil);

        //Add IngredientInstances to recipe
        HashSet<IngredientInstance> inginst = new HashSet<IngredientInstance>();
        //inginst.add(iCookingOil);

        //recipe.setRecipeIngredients(inginst); --> you don't need to do this unless //you have new persisted ingredians



//          recipeDao.update(recipe); update is not needed either

        recipe.prettyPrint();
    }