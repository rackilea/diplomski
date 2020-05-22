public void printPascal(int n) {
    if(!upsideDown)
    {
        if(n < 0)
                return;
            //print the future step first, then print current step
            printPascal(n - 1);
            System.out.println();
            for (int k = 0; k <= n; k++)
            {
                System.out.print(binom(n, k) + " ");
            }


    }
    if (upsideDown)
    {

            if(n < 0)
                return;
            for (int k = 0; k <= n; k++)
            {
                System.out.print(binom(n, k) + " ");
            }
            System.out.println();
            printPascal(n - 1);

    }
}