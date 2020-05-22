static final int CONSTANT = 3;

public static int[] MakeArray()
{
    int[] demo = new int[CONSTANT];
    for(int i=0; i<CONSTANT; i++)
    {
        demo[i]=i;
    }
    return demo;   
}