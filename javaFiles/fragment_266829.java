public class MouseTest {

    public static void main(String[] args) {
        int NUM_SIMULATIONS = 1000;
        Mouse g = new Mouse();
        for(int c = 0;c<NUM_SIMULATIONS; c++)
        {
            g.createIsland();
            g.edgeIsland();
            g.randomStart();
            g.mouseMov();
            if(c<3)
            {
                System.out.println(g.getAns());
                System.out.print(g.printIsland() + "\n---------------------------------------------------------\n\n");
            }
        }

        System.out.println("# of times the mouse escaped: " + g.getEscape()+"%");
        System.out.println("# of times the mouse drowned: " + g.getDrown()+"%");
        System.out.println("# of times the mouse starved: " + g.getStarve()+"%");

    }

}