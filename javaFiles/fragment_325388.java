// int steps = 0; 
// int size = 0; 
Scanner sc = new Scanner(System.in); 
// String [] layout = new String[size]; 
System.out.println("The Game of Life."); 
System.out.print("How many steps in time? "); 
int steps = sc.nextInt(); 
System.out.print("What size is the grid? "); 
int size = sc.nextInt(); 
String [] layout = new String[size]; // <-- here.