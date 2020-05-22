public static void main(String[] args){
     Shoe s = new Shoe();
    Scanner scan= new Scanner(System.in);
    System.out.print("Enter show brand :");
    s.setBrand(scan.next());
    System.out.print("Enter show color :");
    s.setBrand(scan.next());
    System.out.print("Enter show Size :");
    s.setBrand(scan.nextInt());
    System.out.println(s.toString());
 }