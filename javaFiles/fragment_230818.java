A. 0, 2, 4, 4, 6, 8, 10, 6,
   1  1  1  2  2  2   2  1     <- possible threads that produced this output - possible solution

B. 0, 2, 4, 6, 8, 10, 2, 4,
   1  2  2  2  2   ?  1        <- to print second '2', T1 interrupted between L10/L11; 4 passes of T2 used up

C. 0, 2, 4, 6, 8, 10, 12, 14,
   1  1  1  1  2   2   2   2   <- possible solution - simplest solution (T2 waits until T1 is completely done) - doesn't matter that it isn't likely, just that is possible

D. 0, 0, 2, 2, 4, 4, 6, 6, 8, 8, 10, 10, 12, 12, 14, 14,
   1  2  1  2  1  2  1  2  1  2   ?    <- threads used up

E. 0, 2, 4, 6, 8, 10, 12, 14, 0, 2, 4, 6, 8, 10, 12, 14,
   1  1  1  1  2   2   2   2  ?   <- threads used up