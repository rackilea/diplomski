The function adds {1,2,4...} 
So we are up to 4 and we know 1,2,3,4 are covered,
each can be formed from equal or lower numbers in the array.

At any point, m, in the traversal, we know for sure that 
X0 + X1 ... + Xm make the largest number we can make, call it Y.
But we also know that we can make 1,2,3...Xm

Therefore, we can make Y-1, Y-2, Y-3...Y-Xm

(In this example: Xm = 4; Y = 1+2+4 = 7; Y-1 = 6; Y-2 = 5)

Q.E.D.