public class Line {
    public static String WhoIsNext(String[] names, int n)
    {
        // Your code is here...
        final int personNum = names.length;
        int loop = 1;
        int curPersonQueueNum = personNum * loop;
        while (n > curPersonQueueNum){
            n -= curPersonQueueNum;
            loop*=2;
            curPersonQueueNum = personNum * loop;
        }
        n = (int) Math.ceil((double)n / loop);
        return names[n - 1];
    }
}