public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Provide Table  size");
    int tSize = scanner.nextInt();
    String[] id = new String[tSize];
    String[] item = new String[tSize];
    int[] price = new int[tSize];

   for (int i=0; i<tSize; i++){
       System.out.println("Enter ID");
       id[i] = scanner.next();
       System.out.println("Enter Item");
       item[i] = scanner.next();
       System.out.println("Enter price");
       price[i] = scanner.nextInt();
   }

   scanner.close();

    System.out.println("Item Id\t\tItem Description\t\tPrice");

    for(int ix = 0; ix < tSize; ++ix)
    {
        System.out.println(id[ix] + "\t\t\t" + item[ix] + "\t\t\t\t\t" + price[ix]);
    }

}