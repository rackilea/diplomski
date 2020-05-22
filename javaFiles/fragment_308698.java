Scanner scanner = new Scanner(System.in);

//create an instance of kassenzettel to add your produkts to
Kassenzettel list =new Kassenzettel();

//set variable to check if read or not (not needed if using break!)
boolean readOn = true;

//loop for reading until user inputs x or X
while(readOn){
  System.out.println("What would you like? ");
  String produkt = scanner.nextLine();

  //check if produkt name is X or x => exit the loop 
  if(produkt.equalsIgnoreCase("x")){
    readOn = false;
    break;
  }
  System.out.println("How many pieces do you want?");
  int anzahl = scanner.nextInt();
  System.out.println("How much does " + produkt + "cost?");
  double preis = scanner.nextDouble();

  //add a new item to kassenzettel
  list.add(new Eintrag(produkt, anzahl, preis));
}

//print the output of kassenzettel
System.out.println(list.toString());