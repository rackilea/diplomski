List<Proudact> myList = new ArrayList<Proudact>();

myList.add(new Proudact("Milk", 5.55, 50, 10, 0));
myList.add(new Proudact("Chess", 4.35, 50, 10, 1));
myList.add(new Proudact("Apple", 1.25, 50, 10, 2));
myList.add(new Proudact("Wotermelon", 6.21, 50, 10, 3));

public static void NewProd(Proudact[] MyArray){
    Scanner scan = new Scanner(System.in);
    for (int i = 0; i < 1; i++) {
        System.out.println("Enter Proudact Name : ");
        String Name = scan.next();
        System.out.println("Enter Proudact Price : ");
        int price = scan.nextInt();
        System.out.println("Enter Proudact Stuck : ");
        int Stuck = scan.nextInt();
        System.out.println("Enter Proudact MinStuck");
        int minStuck = scan.nextInt();
        System.out.println("Enter Proudact Id :");
        int id = scan.nextInt();
        myList.add(new Proudact(Name,price,Stuck,minStuck, id));
    }
}