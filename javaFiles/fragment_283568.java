public static int primeChecker(Mylist list) { 
    int PrimeNo = 0;
    //insert whatever method here gives you the first node of Mylist
    //I inserted start() to demonstrate, that may or may not be right
    Mynode p = list.start();                    
    while (p != null) 
    {
        int x = p.Data;
        if (isPrime(x)) 
        {
            PrimeNo++;
        }
        p = p.Next;
    }
    return PrimeNo;                               
}