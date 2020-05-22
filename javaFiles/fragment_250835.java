public static void main(String[] args) {

    // create # of games played array
    List<Integer> FTGames = new ArrayList<Integer>();
    FTGames.add(1);
    // create # of shots made array
    List<Integer> ShotsMade = new ArrayList<Integer>();
    System.out.print("Enter Player's Free Throw Percentage: ");
    // Create scanner for user percentage input
    Scanner input = new Scanner(System.in);
    int percent = input.nextInt();
    // FTGames shows []      in this run
    System.out.println("Game " + FTGames.get(0) + ":");
    Random r = new Random();
    FTGames.set(0, FTGames.get(0)+1); // Adds 1 to FTGames
    for (int i = 0; i < 10; ++i){
        boolean in = tryFreeThrow(percent);
        if (in) {
            ShotsMade.add(1);
            System.out.print("In" + " ");
        }
        else {
            ShotsMade.add(0);
            System.out.print("Out" + " ");
        }
    }
    // FTGames shows [1] in this run
    System.out.println("");
    System.out.println("Game " + FTGames.get(0) + ":");
    FTGames.set(0, FTGames.get(0)+1); //Adds 1 to FTGames to make this Game 2 ** But is not showing that **
    for (int i = 0; i < 10; ++i){
        boolean in = tryFreeThrow(percent);
        if (in) {
            ShotsMade.add(1);
            System.out.print("In" + " ");
        }
        else {
            ShotsMade.add(0);
            System.out.print("Out" + " ");
        }
    }
    // FTGames shows [1,1}
    System.out.println("");
    System.out.println("Game " + FTGames.get(0) + ":");
    FTGames.set(0, FTGames.get(0)+1);
    for (int i = 0; i < 10; ++i){
        boolean in = tryFreeThrow(percent);
        if (in) {
            ShotsMade.add(1);
            System.out.print("In" + " ");
        }
        else {
            ShotsMade.add(0);
            System.out.print("Out" + " ");
        }
    }
}