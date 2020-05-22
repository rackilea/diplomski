int counter=0;

void pickUpAllStacks() {
       pickUpBeeperStack();
       moveRobotToNextStack();
      counter += pickUpBeeperStack();
       print("Picked up "+ counter +" beepers");

    }

void moveRobotToNextStack() { 
        while(isSpaceInFrontOfRobotClear()) {
            moveRobotForwards();
            pickUpBeeperStack(); 
        }

    }  

    int pickUpBeeperStack() {

        while(isItemOnGroundAtRobot()) {
            pickUpItemWithRobot();
            counter++;
    }
    return counter;
}