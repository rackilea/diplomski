public class MyTextAdventure {

    private Room[] rooms; //array for all rooms
    int currentRoom = 0;
    boolean over;

    //class constructor
    public MyTextAdventure() {
        rooms = new Room[10]; //Initialize new room array of size 10
        over = false; //game is not over yet

        for(int i = 0; i < rooms.length; i++) {
            //Initialize all rooms
            rooms[i] = new Room();
        }
    }

    public void start() {
        //do your game loop in here
        while(!over) {

        }   
    }

}

public static void main(String [] args){
    MyTextAdventure adventure = new MyTextAdventure();
    adventure.start();
}