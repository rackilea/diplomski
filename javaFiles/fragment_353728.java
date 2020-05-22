players temp = new players();
System.out.print("How many players would you like to enter? ");
int x = Integer.valueOf(br.readLine()).intValue();
arr = new players[x];     

//loop through players
for(int i = 0; i < arr.length; i++)
{

    System.out.println("Enter player information.");

    System.out.println("Input first and last name: ");
    String name = br.readLine();
    temp.name = name;       
     ....