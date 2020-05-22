public RecetteIngredient save(RecetteIngredient recette) {
  this.em.merge(recette.getIngredient());
  this.em.merge(recette.getRecette());

  return this.em.merge(recette);
}