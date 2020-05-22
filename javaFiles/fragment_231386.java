for (Recipe recipe : recipesFounded) {
    if (recipe.getTitle().toLowerCase()
            .contains(word)) {
       trueOnes.add(recipe);
    }
}