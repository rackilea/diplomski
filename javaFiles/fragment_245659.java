void clearStacks() {
    int beepers=0;
    while(isSpaceInFrontOfRobotClear()) {
        moveRobotForwards();

        /* Reset the count of beepers. */
        beepers = 0;

        /* Pick up any beepers at current spot. */
        while(isItemOnGroundAtRobot()) {

            /* Pick up beeper, and increment counter. */
            pickUpItemWithRobot();
            ++beepers; 

        }

        /* Check to see if we picked up any beepers. 
         * if we did, print the amount.
         */
        if(beepers > 0){
            println(beepers);
        }
    }
}