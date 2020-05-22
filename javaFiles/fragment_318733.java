public static void setUnlocked(int id)
{
    unlocked |= 1L<<id; // set the id'th bit
}

public static boolean isUnlocked(int id)
{
    return (unlocked & (1L<<id)) != 0; // get the id'th bit
}