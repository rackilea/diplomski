abstract class Wolumin{
    static int id;
    private final int myId;
    Wolumin(){
        myId = id++;
    };

    int getMyId() {
        return myId;
    }
}