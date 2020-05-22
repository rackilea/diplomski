public class Recursion {

    private static boolean reached = false; 

    public static void main(String[] args) {
        //hailstone(16);  // prints  16 8 4 2 1
        hailstone(1);  //prints just 1 instead of 1 4 2 1
    }

    public static void hailstone(int seed) {
        String str = "" + seed;

        if (seed == 1 && reached) {
            System.out.print(str);
        } else if (seed == 1 && !reached) {
            System.out.print(str + " ");
            reached = true;
            hailstone((3 * seed) + 1);
        } else {
            if (seed % 2 == 0) {
                System.out.print(str + " ");
                hailstone(seed / 2);
            } else {
                System.out.print(str + " ");
                hailstone((3 * seed) + 1);
            }
        }
    }
}