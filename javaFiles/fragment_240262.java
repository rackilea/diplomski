public static void carMaintenance() {
    Scanner sc = new Scanner(System.in);

    String makeOfCar;

    System.out.println("What's the make of your car?");
    makeOfCar = sc.nextLine();

    String[] services = {"Oil Change", "Tire Rotation", "Air Filter", "Fluid Check"};

    double[] prices = {39.99, 49.99, 19.99, 10.99};
    double sum = 0;


    System.out.println("What services whould you like for your " + makeOfCar + "?");
    System.out.println(services[0] + ", " + services[1] + ", " + services[2] + ", " + services[3] + ".");

    String choice;

    //This array simply tracks true or false for chosen/not chosen. boolean arrays are initialized with all values false.
    boolean[] chosenServices = new boolean[services.length]; //Can only be as many elements as there are services. This way you don't have to change it when you add another service
    do {
        choice = sc.nextLine();

        int choiceIndex = getIndex(services, choice);
        if (choiceIndex < 0) break; //Choice doesn't exist. You will have to refine that and add messages

        if (!chosenServices[choiceIndex]) { //service not yet chosen
            chosenServices[choiceIndex] = true;
            sum += prices[choiceIndex];
        } else {
            System.out.println("Was already chosen!");
        }

    } while (!choice.toLowerCase().equals("exit")); //Or something similar

    System.out.printf("%.2f", sum); //Price with 2 digits 

}

public static int getIndex(String[] arr, String search) {
    for (int i=0; i<arr.length; i++) {
        if (search.equals(arr[i]))
            return i;
    }
    return -1;
}