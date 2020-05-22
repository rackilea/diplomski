public class Bug{
    public int x=0;
    public int y=0; 
}

    public class SimpleSim {

    private int  dirNum = 0;
    private int length = 20;
    private int width = 20;
    private boolean canMove = true;
    private Random generator = new Random();
    private boolean endSim = false;

    public static void main(String [] args) {
        SimpleSim simpleSim = new SimpleSim();
        simpleSim.start();

    }

    private void start() {
        Bug myBug = new Bug();
        // Give the bug some initial x, y values.
        myBug.x = 0;
        myBug.y = 0;

        while (endSim == false) {
            nextMove(myBug);
            System.out.print(room.printRoom() + "\n\nNext move? (y/n) ");
            simSentinel = in.next();
            if (simSentinel.charAt(0) == 'n')
               endSim = true;
            }

        }
    }

    public void nextMove(Bug bug){
        if (dirNum == 0 && bug.y < length-1)         //Move up
           bug.y++;
        else if (dirNum == 1 && bug.x < width-1)     //Move right
           bug.x++;
        else if (dirNum == 2 && bug.y > 0)           //Move down
           bug.y--;
        else if (dirNum == 3 && bug.x > 0)           //Move left
           bug.x--;
        else {
           System.out.println("Error: Cannot move " + "?" + ".");
           canMove = false;
           dirNum = generator.nextInt(4);
        }

     }

}