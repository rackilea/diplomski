for (int i=0; i < recipesFounded.size(); i++) {
    if (recipesFounded.get(i).getTitle().toLowerCase()
              .contains(word)) {
       trueOnes.add(recipesFounded.get(i));
    }
}