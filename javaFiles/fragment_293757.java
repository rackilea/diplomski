public static void main(String[] args) 
{
    Scanner scan = new Scanner(System.in);
    int choice, size;

    System.out.println("Enter the size of an array : ");
    size = scan.nextInt();

    ArrayList<Integer> bag = new ArrayList<Integer>(); // arrraylists do not have a size. They automatically expand or decrease

    IntBag intBag = new IntBag(bag, 30); // creates a new IntBag object 
 }