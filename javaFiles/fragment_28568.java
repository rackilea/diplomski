public ArrayList<Menu> randomMenu() {
    ArrayList<Menu> menu = new ArrayList<Menu>();
    int indexEntrees=(int) Math.random() * entree.size() - 1;
    Entree randomEntree = entrees.get(indexEntrees);
    menu.add(randomEntree);

    int indexD=(int) Math.random() * dessert.size() - 1;
    Dessert randomDessert = desserts.get(indexD);
    menu.add(randomDessert);

    int indexSalad=(int) Math.random() * salad.size() - 1;
    Salad randomSalad = salads.get(indexSalad);
    menu.add(randomSalad);

    int indexSide=(int) Math.random() * side.size() - 1;
    Side randomSide = side.get(indexSide);
    menu.add(randomSide);

    return menu;
}