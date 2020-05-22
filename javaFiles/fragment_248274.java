public class GEN implements Comparable<GEN>
{
    int[][] mark=new int[TIMELIMIT][N+1];
    int[][] dimark=new int[TIMELIMIT][N+1];
    int time=0;
    int[] touched=new int[N+1];

    int compareTo(GEN obj)
    {
        // compareTo returns a negative number if this is less than obj, 
        // a positive number if this is greater than obj, 
        // and 0 if they are equal.
        return this.time - obj.time;
    }
}

public GEN[] gend=new GEN[GENNUM];