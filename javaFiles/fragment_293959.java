public static void main(String[] args) {
    System.out.println("Please enter the number of values you would like to enter: ");
    Scanner scan = new Scanner(System.in);
    int intNumberOfNumbers = scan.nextInt();
    ArrayList<Integer> myArray= new ArrayList<>();
    for (int i = 0; i < intNumberOfNumbers; i++) {
        System.out.println("Please enter a value for index " + i + ":");
        int intValue = scan.nextInt();
        myArray.add(intValue);
    }
}