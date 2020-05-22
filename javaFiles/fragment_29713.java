public static void main(String[] args) {
    double [] run1 = new double[7];
    Scanner input = new Scanner(System.in);

    for (int i = 0; i<run1.length; i++)
    {
        System.out.println("Score from Judge " + (i+1) + ": ");
        run1[i] = input.nextDouble();   
    }

    double iMax = run1[0];
    double iMin = run1[0];
    for (int i = 1; i<run1.length; i++)
    { if (run1[i]< iMin)
        iMin = run1[i];
    }

    for (int i = 1; i<run1.length; i++)
    { if (run1[i]> iMax)
        iMax = run1[i];
    }
    System.out.println("the minimum score is: " + iMin);
    System.out.println("the maximum score is: " + iMax);
}