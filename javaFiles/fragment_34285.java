int A[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
int maxReach = A[0];     // A[0]=1, so the maximum index we can reach at the moment is 1.
int step = A[0];         // A[0] = 1, the amount of steps we can still take is also 1.
int jump = 1;            // we will always need to take at least one jump.

/*************************************
 * First iteration (i=1)
 ************************************/
if (i + A[i] > maxReach) // 1+3 > 1, we can reach further now!
    maxReach = 1 + A[i]  // maxReach = 4, we now know that index 4 is the largest index we can reach.

step--                   // we used a step to get to this index position, so we decrease it
if (step == 0) {
    ++jump;              // we ran out of steps, this means that we have made a jump
                         // this is indeed the case, we ran out of the 1 step we started from. jump is now equal to 2.
                         // but we can continue with the 3 steps received at array position 2.
    steps = maxReach-i   // we know that by some combination of 2 jumps, we can reach  position 4.
                         // therefore in the current situation, we can minimaly take 3
                         // more steps to reach position 4 => step = 3
}

/*************************************
 * Second iteration (i=2)
 ************************************/
if (i + A[i] > maxReach) // 2+5 > 4, we can reach further now!
    maxReach = 1 + A[i]  // maxReach = 7, we now know that index 7 is the largest index we can reach.

step--                   // we used a step so now step = 2
if (step==0){
   // step 
}

/*************************************
 * Second iteration (i=3)
 ************************************/
if (i + A[i] > maxReach) // 3+8 > 7, we can reach further now!
    maxReach = 1 + A[i]  // maxReach = 11, we now know that index 11 is the largest index we can reach.

step--                   // we used a step so now step = 1
if (step==0){
   // step 
}

/*************************************
 * Third iteration (i=4)
 ************************************/
if (i + A[i] > maxReach) // 4+9 > 11, we can reach further now!
    maxReach = 1 + A[i]  // maxReach = 13, we now know that index 13 is the largest index we can reach.

step--                   // we used a step so now step = 0
if (step == 0) {
    ++jump;              // we ran out of steps, this means that we have made a jump.
                         // jump is now equal to 3.
    steps = maxReach-i   // there exists a combination of jumps to reach index 13, so
                         // we still have a budget of 9 steps
}


/************************************
 * remaining iterations
 ***********************************
// nothing much changes now untill we reach the end of the array.