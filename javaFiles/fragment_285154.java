public class Main {

//ArrayList
private static ArrayList<Pet> pets = new ArrayList<>();

public static void main (String [] args) {

    try {
        Scanner sc = new Scanner(new File("path/to/file.txt")).useDelimiter(", |\n");

        while (sc.hasNext()) {

            //Get the info for the pet
            Pet pet;

            String name = sc.next();
            String owner_name = sc.next();
            double weight = sc.nextDouble();
            String breed = sc.next();

            //Create the pet and add it to the array list
            pet = new Pet (name, owner_name, weight, breed);
            pets.add(pet);

        }

        sc.close();

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

    //Add your custom pets here if you would like!
    addNewPet ("muffy", "john", 30.0, "beagle");

    //Custom Methods
    printList();
    findHeaviestPet();
    findLightestPet();
    getAveragePetWeight();

}

public static void printList () {

    for (int i = 0; i < pets.size(); i++) {
        System.out.println (pets.get(i).getPet_name()+" "+pets.get(i).getOwner_name()
                +" "+pets.get(i).getWeight()+" "+pets.get(i).getBreed());
    }

}

public static void findLightestPet () {
    //So we know the value will be assigned on the first pet
    double weight = Double.MAX_VALUE;
    int petIndex = 0;

    for (int i = 0; i < pets.size(); i++) {

        if (pets.get(i).getWeight() < weight) {
            weight = pets.get(i).getWeight();
            petIndex = i;
        }
    }

    System.out.println("The lightest pet is "+pets.get(petIndex).getPet_name()+", with a weight of "+pets.get(petIndex).getWeight());
}

public static void findHeaviestPet () {
    double weight = 0.0;
    int petIndex = 0;

    for (int i = 0; i < pets.size(); i++) {

        if (pets.get(i).getWeight() > weight) {
            weight = pets.get(i).getWeight();
            petIndex = i;
        }
    }

    System.out.println("The heaviest pet is "+pets.get(petIndex).getPet_name()+", with a weight of "+pets.get(petIndex).getWeight());
}

public static void getAveragePetWeight() {
    double weights = 0;

    for (int i = 0; i < pets.size(); i++) {

        weights += pets.get(i).getWeight();
    }

    weights = (weights / pets.size());

    System.out.println ("The average weight is "+weights);
}

public static void addNewPet (String name, String o_name, double weight, String breed) {
    Pet pet = new Pet(name, o_name, weight, breed);
    pets.add(pet);
}

}