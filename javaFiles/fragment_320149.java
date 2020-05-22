//you can extract time difference to a variable to avoid recalculating it
int timeDifference = scheduledTimes - estimatedTimes;only once

if (timeDifference == 0){
    System.out.println("The train is on time");
} else if (timeDifference < 1) {
    System.out.println("The train is delayed by 1 minute");
} else if (timeDifference > 1) {
    System.out.println("The train is delayed by x minute");
} else if (timeDifference > 30) {
    System.out.println("Claim compensation");
}