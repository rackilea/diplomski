public static void displayFlowers() {
        for (String name : flowerCount.keySet()) {
            //searchFlower(name);
            System.out.println("Found " + flowerCount.get(name) + " " + name);
        }
    }