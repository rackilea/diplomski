System.out.println ("Enter the number of players on roster: ");
int numPlayers = input.nextInt();
System.out.println();
System.out.println ("Enter the number of games played: ");
int numGames = input.nextInt();
input.nextLine(); //You need this to go to the next line before attempting to get your player names. 
System.out.println();
int[][] arrayScores = new int[numPlayers][numGames];
String[] playerRoster = new String[numPlayers];
System.out.println ("Enter player names: ");
for (int j = 0; j < numPlayers; j++)
{
    playerRoster[j] = input.nextLine();
}