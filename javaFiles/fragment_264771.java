public static void main(String[] args) {
        final int MIN = 1;
        final int MAX = 7;
        int i = MIN;
        int j = MAX;

        while (i <= MAX) {
            j = MIN;
            while (j <= MAX) {
                if (i == j)
                    if (i == (MIN + MAX) / 2)
                        System.out.print("o");
                    else
                        System.out.print("*");
                else if (i + j == MIN + MAX)
                    System.out.print("*");
                else
                    System.out.print(" ");
                j++;
            }
            System.out.println();
            i++;
        }
    }