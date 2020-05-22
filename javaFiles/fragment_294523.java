public static int travel (int i, int j,int k)
   {
    //value temporarily takes the position's value
    int value;

    //if position is out of matrix bounds
    if(i>=x||j>=y||i<0||j<0)
    {
        return 0;
    }
    else
    {
        //makes the value in point (i,j) = 0
        value=M[i][j];
        M[i][j]=0;

        //if the number of turns has been reached
        if(k==turns)
        {
            //restores value at position
            M[i][j]=value;
            return M[i][j];
        }
        else
        {   
            int sum = 0;
            //loop for going to all 8 neighbors
            for(int line=-1;line<2;line++)
            {
                for(int col=-1;col<2;col++)
                {
                    //if the position is the same
                    if(!(col==0&&line==0))
                    {
                        sum=Math.max(travel(i+line,j+col,k+1), sum);
                    }
                }
            }

            //restores value at position
            M[i][j]=value;

            //returns sum so far
            return sum+M[i][j];
        }
    }
}