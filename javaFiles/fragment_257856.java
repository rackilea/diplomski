static ArrayList<Integer> vector(int vectorSize) 
    {
    System.out.println("Kindly provide details for the Vector: ");
    ArrayList<Integer>distance= new ArrayList<Integer>();  
    Scanner scan = new Scanner (System.in);

    for(int i = 0; i < vectorSize; i++) {
    System.out.println("Enter your distance: ");
    int dista = scan.nextInt();
    distance.add(dista); 
    }       
   return distance;
    }