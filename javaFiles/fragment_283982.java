{
        r1 = 'allocate memory for Y' // constructor of Y
        r2 = 'allocate memory for X' // constructor of X
        r2.i = 5;                    // constructor of X
        r1.x = r2;                   // constructor of X
        Y.y = r1;
}