{
        r1 = 'allocate memory for Y' // 1.
        r2 = 'allocate memory for X' // 2.
        r1.x = r2;                   // 3.
        Y.y = r1;                    // 4.
        r2.i = 5;                    // 5.
}