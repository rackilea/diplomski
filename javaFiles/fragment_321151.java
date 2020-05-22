private static void filterFlower (ArrayList<Flower> flowers) {

    String partialName = getString("Enter the partial name of the flower: ");

    ArrayList<Flower> filteredFlowers = new ArrayList<Flower>();
    for(Flower flower: flowers){
        if (flower.getName().contains(partialName)){
            filteredFlowers.add(flower);
        }
    }
    if (filteredFlowers.size() > 0){
        System.out.println("The flowers containing " + partialName + " are: ");
        for(Flower flower: filteredFlowers){
            System.out.println(flower.getName());
        }
    }
    else {
        System.out.println("None of the flowers contain " + partialName);
    }
}