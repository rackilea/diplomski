System.out.println("Qualifies for instate rate: ");
instate = keyboard.nextLine();
while((instate.equalsIgnoreCase("yes") == false && instate.equalsIgnoreCase("no") == false))
{
    System.out.println("Enter either yes or no:");
    instate = keyboard.nextLine();
}