public static void main(String args[]) {
        for (int i = 1; i < 50; i++)
            if (fn(i) != fn2(i))
                System.out.println ("BAD:  " + i + ": " + fn(i) + ", " + fn2(i)
                    + " (" + Math.abs(fn(i) - fn2(i)) + ")");
            else
                System.out.println ("GOOD: " + i + ": " + fn(i) + ", " + fn2(i));
        }
    }