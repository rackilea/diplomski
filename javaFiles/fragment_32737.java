ArrayList<Player> players = new ArrayList<Player>();
int numOfPlayers;

System.out.println("How many players are in this game?");
numOfPlayers = input.nextInt();


for(int i = 0; i < numOfPlayers; i++)
{
    System.out.print("What is Player " + (i + 1) + " name?");
    String name = input.next();
    Player plr = new Player();
    plr.setName(name);
    players.add(plr);
}