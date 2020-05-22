public class Locations {

    Player_Information plIn = new Player_Information();

    public void startingHouse() {
        plIn.PlayerName(); // call this first to initialize playerOneName;
        System.out.println(plIn.getPlayerOneName() + ": Agh.. What happened..");
    }
}