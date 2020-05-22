Scanner scan=new Scanner(System.in);
    System.out.println("Enter the string:-");
    String st=scan.nextLine();
    Scanner sc=new Scanner(st);
    String arr[]=new String[4];
    int i=0;
    double val=0;
    int n=0;
    while(i<4){
        String st1=sc.next();
        arr[i]=st1;
        i++;
    }
    if(arr[0].equalsIgnoreCase("amount")){
    n=Integer.parseInt(arr[3]);
    val=Double.parseDouble(arr[1]);
}
    if(arr[0].equalsIgnoreCase("years")){
        val=Double.parseDouble(arr[3]);
        n=Integer.parseInt(arr[1]);
    }