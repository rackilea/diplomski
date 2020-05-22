public class WaysToScore 
{
    static long count=0;

    public static void waysToDo(int score, int target, List<Short> waySoFar)
    {
        if(waySoFar.size() > 6) return;  //  total balls

        if(score >= target && score < target+6)
        {
            count++;
            return;
        }

        for(short i=0; i<=6; i++)   //  scoring options per ball
        {
            waySoFar.add(i);

            waysToDo(score+i, target, waySoFar);

            waySoFar.remove(waySoFar.size()-1);
        }
    }

    public static void main(String[] args) 
    {
        int target = 6 ;  //  total scores.

        waysToDo(0, target, new ArrayList<Short>());

        System.out.println("Total ways: "+count);
    }
}