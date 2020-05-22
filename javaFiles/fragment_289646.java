// RANDOM GENERATOR
public static int randomGen(int checkvar1)
{
    Random rand = new Random();
    int var1 = rand.nextInt(checkvar1) + 1;
    return var1;
}