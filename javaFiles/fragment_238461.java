public class Group {
    public static Group A = new Group(10000,20000,30000);
    public static Group B = new Group(40000,50000,60000);
    public static Group C = new Group(70000,80000,90000);

    private int primaryMin;
    private int primaryMid;
    private int secondaryMax;

    private Group(int min, int mid, int max) {
        primaryMin = min;
        primaryMid = mid;
        secondaryMax = max;
    }

    public boolean getLevel(int level, int primaryAmount, int secondaryAmount) {
       if (level == 0)
         return primaryAmount > primaryMin;
       else if (level == 1) 
         return primaryAmount > primaryMid;
       else 
         return secondaryAmount > secondaryMax;
    }
}