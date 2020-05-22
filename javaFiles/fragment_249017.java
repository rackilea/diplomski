public static void displayFlowers(){
    //int repeats = 0;
    List<String> displayedFlowerTypes = new ArrayList<String>();
    for (FlowerClass flower: flowerPack){
        String name = flower.getName();
        if(!displayedFlowerTypes.contains(name))
        {
            displayedFlowerTypes.add(name);
            searchFlower(name);
        }
    }
}