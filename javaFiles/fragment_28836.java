public class HailStone {
    /* static variable to count calls to hailStone */
    public static int iterCount = 0;

    /* This variable is a senti */
    public static boolean isRepeating = 0;

    /* Simple main function */
    public static void main(String[] args) {
        // TODO:
        //   Either parse args or use a scanner to get input.
        //   Args = verbose, entryPoint
        hailStone(10, true);
    }

    /* Recursive hailStone implementation */
    private static void hailStone(int a, boolean showNumbers) {
        // start off by printing the numbers if showNumbers is true
        if (showNumbers) {
            System.out.printf("Iteration #%d: %d\n", ++iterCount, a);
        }

        // base case: a = 1 => most important part of recursion
        if (a == 1) {
            if (isRepeating) {
                return;
            }
            isRepeating = true;
        }

        // check if a is odd
        // You can use modulo divison, but we'll use bitwise &
        /* Explained: [ bitwise AND... bits that are set in a AND in 1 ]
        **********************************************
             Case 1: a is even =>
                 a = 10
                 10 in binary is 00001010
                  1 in binary is 00000001
            ------------------------------
             10 & 1 in binary is 00000000

             Case 2: a is odd =>
                 a = 10
                 11 in binary is 00001011
                  1 in binary is 00000001
            ------------------------------
             11 & 1 in binary is 00000001
        **********************************************
            set(X) = set of all even numbers
            set(Y) = set of all odd numbers
            {
              x is any arbitrary number in set X,
              y is any arbitrary number in set Y
            }
            x & 1 will ALWAYS equal 0 -\
                                        >- know this. bitwise hacks rock.
            y & 1 will ALWAYS equal 1 -/
        */
        if ((a & 1) == 1) {
            a *= 3;
            a += 1;
        } else {
            a /= 2;
        }

        // Tail recursion.
        hailStone(a, showNumbers);
        return;
    }
}