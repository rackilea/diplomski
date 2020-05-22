public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Enter the car's year model: ");
    int year = keyboard.nextInt();
    keyboard.nextLine();
    System.out.println("Enter the car's make: ");
    String make = keyboard.nextLine();
    System.out.println("Enter the car's speed: ");
    int speedIn = keyboard.nextInt();

    Car car = new Car(year, make, speedIn);        
}