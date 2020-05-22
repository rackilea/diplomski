public static class Dinner {
ArrayList<Iedible> foods = new ArrayList<Iedible>();

public Dinner(Iedible... food) {
    for (int i = food.length - 1; i >= 0; i--)
    foods.add(food[i]);
}

public void tryEverything() {
    for (int i = foods.size() - 1; i >= 0; i--)
    foods.get(i).eat();
}
}