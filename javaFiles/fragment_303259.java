public class Anthill {

    ArrayList <Ant> antHill = new ArrayList<>();

    public void adde(Ant ant)
    {
        if(ant != null)
        {
        // Assuming ant.isQueen() returns a boolean.
        // amountOfQueens must be 0 to permit the insertion of max 1 Queen instance in the list
        if (ant.isQueen() && amountOfQueens == 0)
        {
            antHill.add(ant);
            amountOfQueens++;
        } 
        else if (ant.isQueen() == false) 
        {
            antHill.add(ant);
            amountOfAnts++;
        }
        else   
        { 
            System.out.println("Only one queen is permitted.");
        }
    }
}