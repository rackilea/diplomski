public static void main(String[] args) {
    Dog fido = new Dog("poodle", false, 4, 31);
    Dog nunzio = new Dog("shiba inu", true, 12, 3);
    Dog las = new Dog("Collie", true, 5, 4);

    List<Dog> list = new ArrayList<>();
    list.add(fido);
    list.add(nunzio);
    list.add(las);

    // We use a custom comparator that compares two Dog instances 'a' and 'b' based on the favThings field:
    Dog maxDog = Collections.max(list, (a,b) -> Integer.compare(a.favThings, b.favThings));

    System.out.println("The dog with the most fav things is " + maxDog.breed);
}