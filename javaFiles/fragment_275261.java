public static void main(String[] args) {
// main method

System.out.println("Hello and welcome to my text adventure! ");
List<String> names = Arrays.asList("mage","archer","warrior");
Scanner myinput = new Scanner(System.in);
Player gameplayer = new Player(); // create a player object and assign it to gameplayer
System.out.print("Please enter your name.\n");
String nameofPlayer = myinput.nextLine();
gameplayer.setPlayer(nameofPlayer);


System.out.print("Please enter your class. (Mage, Archer, Warrior)\n");
String userinput;
while (myinput.hasNext() || myinput.hasNextInt()) {
    userinput = myinput.nextLine();
    String nameofClass = userinput.toLowerCase();
    if (!names.contains(nameofClass)) {
        System.out.println("I'm sorry, what was that?");

    } else {
        gameplayer.setclassName(nameofClass);
        System.out.println("Hello " + gameplayer.getPlayer() + " the "+ gameplayer.getClassName()+ ". What health do you have?");

        int numberofHealth = myinput.nextInt();
    }
    System.out.println("Very good. Now let's get started on your adventure.");
    gameplayer.setHealth(numberofHealth);
    return;
   }
}