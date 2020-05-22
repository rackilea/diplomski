public static void main (String[] args) {

    List<Human> randomObjects = new ArrayList<>();
    for (int j = 0; j < 5; j++) {

        Fysiker randomFysiker = new Fysiker();
        randomObjects.add(randomFysiker);

        Human randomHuman = new Human();
        randomObjects.add(randomHuman);
    }
    System.out.println(randomObjects);

    Collections.sort(randomObjects);
}