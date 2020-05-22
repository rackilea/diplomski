public static void main(String[] args) {
    int b;
    boolean isPrime;

    for (int a=2; a<=100; a++)
    {
        isPrime = true;
        for (b=2; b<a;b++)
        {
            if (a%b==0)    
            {
                isPrime = false;
                break;
            }
        }
        if (isPrime)
        {
            System.out.println(a);
        }
    }
}