import java.util.Hashtable;

public class findPat {
    static final int COUNT = 100;

    static Hashtable<String, Integer> compareSet = new Hashtable<String, Integer>();
    static String groupInteger = "";
    static int arr [] = new int [5];
    static int st = 1;
    static int end = 56;
    static double t1;
    static double t2;

    public static void main(String[] args) {
        t1=System.currentTimeMillis(); 
        for(int n = 0; n < COUNT; n++){
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (Math.random()* (end - st + 1)) + st;

            }
            for (int i = 1; i <= 5; i++) {
                groupInteger += arr[i-1];
                System.out.print("\t" + arr[i-1]);
                if (i % 5 == 0) {
                    System.out.println();
                    if (compareSet.containsKey(groupInteger)) {
                        System.out.println("duplicate found");
                        int currentCount = compareSet.get(groupInteger);
                        compareSet.put(groupInteger, currentCount + 1);
                    } else {
                        compareSet.put(groupInteger, 1);                        
                    }
                    groupInteger = "";
                }

            } 
        }
        t2=System.currentTimeMillis();
        System.out.println();
        System.out.println();
        System.out.println("\t" + "Total run time is " + ((t2 - t1)) + "ms");
    }
}