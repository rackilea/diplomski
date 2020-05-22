int choice;
boolean goldTaken = false;

if(goldTaken)
{
    System.out.println("There is a table to your right.");
    System.out.println("Left of you is a door.");
    System.out.println("1: Go through door.");
    System.out.println("2: Go back.");
}
else
{
    System.out.println("On the table to your right you find 13 gold!");
    System.out.println("Left of you is a door.");
    System.out.println("1: Pick .up gold");
    System.out.println("2: Go through door.");
    System.out.println("3: Go back.");
}

// remember to change the conditional if the player chooses to take the gold

if( choice==1) {
goldTaken = true;
myGold = myGold + 13;

// ... the rest of your existing code