private int correctedDirectionCalculation(int calculation){
   return calculation >= 0 ? calculation : calculation + 360;
}

public void chooseDirection() {
    int targetDirection = 5;
    int currentDirection = 360;

    int goingRightDistance = correctedDirectionCalculation(targetDirection - currentDirection);
    int goingLeftDistance = correctedDirectionCalculation(currentDirection - targetDirection);

    System.out.println(goingLeftDistance < goingRightDistance ? "Go Left!" : "Go Right!");
}