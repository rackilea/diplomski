/**
 * This simulation assumes Ant movement is discrete relative to grid cells
 * i.e. its either in one of these cells at a time, overlapping two cells in not allowed!!
 * **/
public class AntMovementSimulation 
{
    int onBoard[][] = null;
    int antPosX = 0;
    int antPosY = 0;
    int antPrevPosX = 0;
    int antPrevPosY = 0;

    int directionOfMovement = 0;
    int stepsCount = 0;

    AntMovementSimulation()
    {
        onBoard = new int[8][8];
        //initialize each position in onBoard to -1 ,implying Ant has not been placed yet, not even once!!
        for( int i = 0 ; i < 8 ; i++ )
        {
            for( int j = 0 ; j < 8 ; j++ )
            {
                onBoard[i][j] = -1;//implying Ant has not been placed yet, not even once!!
            }
        }

        //place Ant in random cell
        antPosX = (int)Math.round(Math.random()*7);//generating random number between 0 and 7, since index is from 0 to 7 as there are 8 cell!!
        antPosY = (int)Math.round(Math.random()*7);
        //assigning 1 to onBoard at index antPosX,antPosY to indicate Ant has been placed there
        onBoard[antPosX][antPosY] = 1;
    }

    /*this function returns false if any cell has -1,else true
     * cause when all cells have been traversed , each cell have non negative value,either 0 or 1 
     *  */
    public boolean areAllCellsTraversed()
    {
        boolean result = true;

        for( int i = 0 ; i < 8 ; i++ )
        {
            for( int j = 0 ; j < 8 ; j++ )
            {
                if( onBoard[i][j] == -1 )//implying this cell not traversed yet,i.e Ant not placed in this cell yet!!
                {
                    result = false;
                }
            }
        }
        return result;
    }

    public void simulate()
    {
        //loop while all cells have been not traversed
        while( !areAllCellsTraversed() )
        {
            directionOfMovement = (int)Math.round(Math.random()*3);//generating random number between 0 and 3
            switch( directionOfMovement )
            {
            case 0://move left-to-right
                antPosX += 1;
                if( antPosX >= 7 ) antPosX = 0; //since largest array index is 1 less than its size, we compare with 7 instead of 8                 
                break;

            case 1://move right-to-left
                antPosX -= 1;
                if( antPosX <= 0 ) antPosX = 7;                 
                break;

            case 2://move top-to-bottom
                antPosY += 1;
                if( antPosY >= 7 ) antPosY = 0;                 
                break;

            case 3://move bottom-to-top
                antPosY -= 1;
                if( antPosY <= 0 ) antPosY = 7;                 
                break;
            }

            //assign 0 to previous position, meaning Ant is no longer there
            onBoard[antPrevPosX][antPrevPosY] = 0;
            //assign 1 to new position , meaning Ant is here
            onBoard[antPosX][antPosY] = 1;

            stepsCount++;
            antPrevPosX = antPosX;
            antPrevPosY = antPosY;                  
        }   
        //once all cells have been traversed , print result!!
        printSteps();
    }   

    /*prints the total number of step taken to traverse all cells*/
    public void printSteps()
    {
        System.out.println("Total steps taken by Ant to traverse all cells = "+stepsCount);
    }

    public static void main(String[] args)
    {
        int sumOfTotalNumOfSteps = 0;
        AntMovementSimulation[] amsArray = new AntMovementSimulation[10];
        for( AntMovementSimulation ams: amsArray )
        {
            ams = new AntMovementSimulation();
            ams.simulate();
            sumOfTotalNumOfSteps += ams.stepsCount;
        }
        System.out.println("Average num of steps taken by Ant to traverse all cells = "+ sumOfTotalNumOfSteps/10);
    }
}