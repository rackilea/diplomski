public static class RobotArena{
    int Arena[][] = new int[4][4];


public void setCoordinates(int x,int y){
    Arena[x][y] = '1';
}
public void printArena(){
     for (int[] a : Arena) { //this prints out the grid
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }
}
}

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("How many Robots in your world?");
        int numRobots = s.nextInt();

       RobotArena allRobots=new RobotArena();

        int rx, ry;

        System.out.println("Now enter position of each robot in turn (as x y) >");
        for (int ct = 0; ct<numRobots; ct++) {
            System.out.println("Enter, x y position for " + ct + "th robot: >");
            rx = s.nextInt();
            ry = s.nextInt();
            allRobots.setCoordinates(rx, ry);

            //allRobots[ct].printIdPosition(); 
        }
        allRobots.printArena();
    }