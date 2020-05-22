public class Main
{
    public static void main(String[] args)
    {
        long now = System.currentTimeMillis();
        slow();
        System.out.println("slow elapsed " + (System.currentTimeMillis() - now) + " ms");

        now = System.currentTimeMillis();
        fast();
        System.out.println("fast elapsed " + (System.currentTimeMillis() - now) + " ms");
    }

    private static void fast()
    {
        StringBuilder s = new StringBuilder();
        for(int i=0;i<100000;i++)
            s.append("*");      
    }

    private static void slow()
    {
        String s = "";
        for(int i=0;i<100000;i++)
            s+="*";
    }
}