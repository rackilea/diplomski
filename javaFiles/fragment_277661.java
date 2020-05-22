public class ForLoop
{
    public static void main (String[] args) 
    {
        for (int outer = 0; outer <= 15; ++outer)
            for (int inner = 0; inner <=4; ++inner)
                System.out.println (outer + "." + inner);
    }
}