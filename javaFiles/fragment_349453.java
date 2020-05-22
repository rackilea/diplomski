public static void main(String[] args)
{
    int[] interval = {5,10};
    int[] t1 = {3,6,9,10};
    int[] t2 = {2,4,5,6,10};

    System.out.println(getIntersectingContinuousRanges(interval, t1));
    System.out.println(getIntersectingContinuousRanges(interval, t2));
}