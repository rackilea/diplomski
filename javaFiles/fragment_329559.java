public class A
{
    private static char[] alphabet = {'a', 'b', 'c', '1', '2'};
    private static StringBuilder partialSolution = new StringBuilder();
    private static void bt(int maxIndex, int index)
    {
    if( index == maxIndex )
        {
            String solution = partialSolution.toString();
            System.out.println(solution);
        }
    else
        {
        for(char c: alphabet)
            {
                // Extend partial solution
                partialSolution.append(c);

                bt(maxIndex, index+1);
                final int lastCharIndex = partialSolution.length()-1;

                // Backtrack
                partialSolution.deleteCharAt(lastCharIndex);
            }
        }
    }
    private static void btCaller(int maxIndex)
    {
        bt(maxIndex, 0);
    }
    public static void main(String[] args)
    {
        btCaller(3);
    }
}