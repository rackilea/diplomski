numbers(5);
    if(5 > 0)--> true : 
        System.out.print(5 + " "); // (1)
        numbers(3);
        |   if(3 > 0)--> true : 
        |       System.out.print(3 + " "); // (2)
        |       numbers(1);
        |       |   if(1 > 0)--> true : 
        |       |       System.out.print(1 + " "); // (3)
        |       |       numbers(-1);
        |       |       System.out.print(1 + " "); // (4)
        |       System.out.print(3 + " "); // (5)
        System.out.print(5 + " "); // (6)