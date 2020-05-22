System.out.println("How many different types of food do the gerbils eat?");

Scanner keyboard = new Scanner(System.in);
int numberofitems = keyboard.nextInt();
keyboard.nextLine();


String[] fooditems = new String[numberofitems];

for(int i=0; i<fooditems.length; i++){

  System.out.println("Name of food item " + (i+1) + ":");

  fooditems[i]= keyboard.nextLine();