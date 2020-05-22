public class CarApp {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        char userCon = 'Y';

        System.out.println("Welcome to the Garage!");

        while(userCon =='Y') {
            System.out.println("How many cars will you be entering?");
            int carAmount = scan.nextInt();
            ArrayList<Car> carList = new ArrayList<Car>(carAmount);

            for(int i =0;i<carAmount;i++) {
                Car car = new Car();
                System.out.println("Enter the make of the car " + (i + 1) + ":");
                car.make = scan.next();

                System.out.println("Enter the model of the car: ");
                car.model = scan.next();
                System.out.println("Enter the year: ");
                car.year = scan.nextInt();
                System.out.println("Enter the price: ");
                car.price = scan.nextDouble();

                System.out.println("Thank you, Car " + (i + 1) + " is set!");
                carList.add(car);
            }
            System.out.println("The garage is holding " + carAmount + " cars.");
            for (Car car : carList) {
                System.out.println("Make: " + car.getMake());
                System.out.println("Model: " + car.getModel());
                System.out.println("Year: " + car.getYear());
                System.out.println("Price: " + car.getPrice());
            }

            System.out.println("Would you like to try again? Y/N");
            String word = scan.next();
            word = word.toUpperCase();
            userCon = word.charAt(0);
        }
        scan.close();
    }