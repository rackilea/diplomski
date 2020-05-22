public Map<Ingredient,Long> createShoppingList() {

// if any of the chained methods below return null, a NullPointerException occurs
// You could extract a method which takes the userInfoService user as an argument, see `findUser` below.
    user = userRepository.findByLoginAndPassword(userInfoService.getUser().getLogin(),userInfoService.getUser().getPassword()).get();

// the above would then  become:
    User user = findUser(userInfoService.getUser()).orElseThrow(new ShoppingServiceException("User not found");

// instead of clearing these field, just initialize them as local variables:       
    shoppingList.clear();
    meals.clear();

    meals = user.getDiet().getMeals();

// I would change adjustIngredients so it doesn't return the meals but void
// it's expected that such a method modifies the meals without making a copy
    meals = dietMealsService.adjustIngredients(meals);

// I would extract the below iteration into a separate method for clarity
    for (MealInfo meal : meals) {

// I would also extract the processing of a single meal into a separate method
// the `meal.getIngredients` actually doesn't return Ingredients but IngredientWeights
// this is very confusing, I would rename the field to `ingredientWeights`
        meal.getMeal().getIngredients().forEach(s -> {
// I would replace the four calls to s.getIngredient() with one call and a local variable
// and probably extract another method here
// You are using Ingredient as the key of a Map so you must implement
// `equals` and // `hashCode`. Otherwise you will be in for nasty 
// surprises later when Java doesn't see your identical ingredients as 
// equal. The simplest would be to use the database ID to determine equality.
            if(shoppingList.containsKey(s.getIngredient()))
                shoppingList.put(s.getIngredient(), s.getWeight()+shoppingList.get(s.getIngredient()));
            else
            shoppingList.put(s.getIngredient(),s.getWeight());
        });
    }
    return shoppingList;
}


private Optional<User> findUser(my.service.User user) {
    if (user != null) {
        return userRepository.findByLoginAndPassword(user.getLogin(), user.getPassword());
    }
    else {
        return Optional.empty();
    }
}

private void processMeals(List<MealInfo> meals, Map<Ingredient, Long> shoppingList) {
    for (MealInfo mealInfo : meals) {
        processIngredientWeights(mealInfo.getMeal().getIngredients(), shoppingList);
    }
}

private void processIngredientWeights(List<IngredientWeight> ingredientWeights, Map<Ingredient, Long> shoppingList) {
    for (IngredientWeight ingredientWeight: ingredientWeights) {            
        processIngredientWeight(ingredientWeight, shoppingList);
    }
}

private void processIngredientWeight(IngredientWeight ingredientWeight, Map<Ingredient, Long> shoppingList) {          
    Ingredient ingredient = ingredientWeight.getIngredient();
    Long weight = shoppingList.getOrDefault(ingredient, 0L);
    weight += ingredientWeight.getWeight();
    shoppingList.put(ingredient, weight);
}