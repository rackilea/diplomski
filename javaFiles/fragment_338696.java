List<Element> listRecettes = courant.getChildren("recipes");
Iterator<Element> i2 = listRecettes.iterator();
while(i2.hasNext()){
  Element sousCourant = (Element)i2.next();

  // New code here
  List<Element> listrecipe = sousCourant.getChildren("recipe");
  Iterator<Element> i3 = listrecipe.iterator();
  while(i3.hasNext()){
    Element recipe = (Element)i3.next();
    promotions.get(index).addRecipe(recipe.getTextContent()); 

  }
}