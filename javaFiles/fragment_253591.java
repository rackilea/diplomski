public static boolean moreThanOnce(ArrayList<Integer> list, int searched) 
{
    int numCount = 0;

    for (int thisNum : list) {
        if (thisNum == searched) numCount++;
    }

    return numCount > 1;
}