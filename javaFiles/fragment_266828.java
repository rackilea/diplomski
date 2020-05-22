import java.util.Random;

public class Mouse {
    final int NUM_ROWS = 10;
    final int NUM_COLS = 15;
    final int MAX_MOVES = 50;
    private double drown = 0;
    private double starve = 0;
    private double escape = 0;
    int[][] island = new int[NUM_ROWS][NUM_COLS];
    Random rand = new Random ();





    public double getStarve()
    {
        double starveF = starve * 10/100;
        return starveF;
    }

     public double getDrown()
    {
         double drownF = drown * 10/100;
       return drownF;
    }

     public double getEscape()
    {
         double escapeF = escape * 10/100;
       return escapeF;
   }


    public void createIsland()
    {
       for (int r = 0; r < island.length; r++)
       {
          for (int c = 0; c < island[r].length; c++)
          {
                island[r][c] = 0;           
          }

      }
    }

    public String printIsland()
    {
        String ans = "";
       for (int r = 0; r < island.length; r++)
       {
          for (int c = 0; c < island[r].length; c++)
          {
              if(island[r][c] == -1)
              {
                  ans+= "b   ";

              }
              else if(island[r][c] == -2)
              {
                  ans+= "w   ";
              }
              else if(island[r][c] == -3)
              {
                  ans+= "W   ";
              }
              else if(island[r][c] == -4)
              {
                  ans+= "B   ";
              }
              else if(island[r][c]>=10)
              {
                 ans+= island[r][c] + "  ";     
              }
              else
              {
                 ans+= island[r][c] + "   ";     
              }

          }
         ans+="\n";
      }
    return ans;
    }



    public void edgeIsland() 
    {
        for(int r = 0; r<island.length;r++)
        {
            float chance = rand.nextFloat();

              if (chance <= .30f)
              {
                  island[r][0] = -1;
              }
              else
              {
                  island[r][0] = -2;
              }
        }
        for(int r = 0; r<island[0].length;r++)
        {
            float chance = rand.nextFloat();

              if (chance <= 0.30f)
              {
                  island[0][r] = -1;
              }
              else
              {
                  island[0][r] = -2;
              }
        }

        for(int r = 0; r<island[0].length;r++)
        {
            float chance = rand.nextFloat();

              if (chance <= 0.30f)
              {
                  island[9][r] = -1;
              }
              else
              {
                  island[9][r] = -2;
              }
        }
        for(int r = 0; r<island.length;r++)
        {
            float chance = rand.nextFloat();

              if (chance <= 0.30f)
              {
                  island[r][14] = -1;
              }
              else
              {
                  island[r][14] = -2;
              }
        }

    }
    int start = 0;
    public void randomStart()
    {

        start = island[4][7] += 1;
    }

        String ans = "";        
        public String getAns()
        {

            return ans;
        }

          public void mouseMov()
          {
            int moveCount = start;


             int move = rand.nextInt((4 - 1) + 1) + 1;

             for(int k = 0; k < MAX_MOVES; k++)
             {
                for (int i = 0; i < island.length; i++)
                {
                   for (int j = 0; j < island[i].length; j++)
                   {
                      if (island[i][j] == moveCount && moveCount <= MAX_MOVES)
                      {
                          move =  rand.nextInt((4 - 1) + 1) + 1;


                         if (move == 1)
                         {
                            if (moveCount == MAX_MOVES)
                            {

                               ans = "The mouse wandered" +  " around and starved!";
                               starve++;
                               moveCount = MAX_MOVES+1;
                               break;
                            }
                            else if (island[i][j-1] == -2)
                            {

                               ans = "The mouse drowned in" +
                               " the water!";
                               drown++;
                               moveCount++;
                               island[i][j-1] = moveCount;
                               moveCount = MAX_MOVES+1;
                               island[i][j-1] = -3;
                               break;
                            }
                            else if (island[i][j-1] == -1)
                            {

                               ans = "The mouse found a bridge" +
                               " and escaped!";
                               escape++;
                               moveCount++;
                               island[i][j-1] = moveCount;
                               moveCount = MAX_MOVES+1;
                               island[i][j-1] = -4;
                               break;
                            }
                            else
                            {
                                moveCount++;
                               island[i][j-1] = moveCount;
                            }
                         }
                         else if (move == 2)
                         {
                            if (moveCount == MAX_MOVES)
                            {

                               ans = "The mouse wandered" +
                              " around and starved!";
                               starve++;
                               moveCount = MAX_MOVES+1;
                               break;
                            }
                            else if (island[i][j+1] == -2)
                            {

                               ans = "The mouse drowned in" +
                               " the water!";
                               drown++;
                               moveCount++;
                               island[i][j+1] = moveCount;
                               moveCount = MAX_MOVES+1;
                               island[i][j+1] = -3;
                               break;
                            }
                            else if (island[i][j+1] == -1)
                            {

                               ans = "The mouse found a bridge" +
                               " and escaped!";
                               escape++;
                               moveCount++;
                               island[i][j+1] = moveCount;
                               moveCount = MAX_MOVES+1;
                               island[i][j+1] = -4;
                               break;
                            }
                            else
                            {
                                moveCount++;
                               island[i][j+1] = moveCount;

                            }
                         }
                         else if (move == 3)
                         {
                            if (moveCount == MAX_MOVES)
                            {

                               ans = "The mouse wandered" +
                                  " around and starved!";
                               starve++;
                               moveCount = MAX_MOVES+1;
                               break;
                            }
                            else if (island[i-1][j] == -2)
                            {

                               ans = "The mouse drowned in" +
                               " the water!";
                               drown++;
                               moveCount++;
                               island[i-1][j] = moveCount;
                               moveCount = MAX_MOVES+1;
                               island[i-1][j] = -3;
                               break;
                            }
                            else if (island[i-1][j] == -1)
                            {

                               ans = "The mouse found a bridge" +
                               " and escaped!";
                               escape++;
                               moveCount++;
                               island[i-1][j] = moveCount;
                               moveCount = MAX_MOVES+1;
                               island[i-1][j] = -4;
                               break;
                            }
                            else
                            {
                                moveCount++;
                               island[i-1][j] = moveCount;
                            }
                         }
                         else
                         {
                            if (moveCount == MAX_MOVES)
                            {

                               ans = "The mouse wandered" +
                                  " around and starved!";
                               starve++;
                               moveCount = MAX_MOVES+1;
                               break;
                            }
                            else if (island[i+1][j] == -2)
                            {

                               ans = "The mouse drowned in" +
                               " the water!";
                               drown++;
                               moveCount++;
                               island[i+1][j] = moveCount;
                               moveCount = MAX_MOVES+1;
                               island[i+1][j] = -3;
                               break;
                            }
                            else if (island[i+1][j] == -1)
                            {

                               ans = "The mouse found a bridge" +
                               " and escaped!";
                               escape++;
                               moveCount++;
                               island[i+1][j] = moveCount;
                               moveCount = MAX_MOVES+1;
                               island[i+1][j] = -4;
                               break;
                            }
                            else
                            {
                                moveCount++;
                               island[i+1][j] = moveCount;
                            }
                         }
                      }
                  }
              }
          }
     }
}