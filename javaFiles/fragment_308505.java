String confirmName;
do
{
    out.println("Please enter the name of your space bug and press <enter> to continue");
    out.println();
    bugOne.setName(keyInput.nextLine());

    out.println("You have entered '" + bugOne.getName() + "'.");
    out.println("Is this correct? (y/n)");

    confirmName = keyInput.nextLine();
}
while(!confirmName.equalsIgnoreCase("y"));