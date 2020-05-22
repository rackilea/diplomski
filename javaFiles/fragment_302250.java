if(isSleepy()){
    sleep(1);
} else {
    // The below only happens if isSleepy() returned false
    if (isBored()){
        dance();
        dance();
    } else {
        // These only happen if isSleepy() returned false AND isBored() returned false
        walkRight(50);
        walkLeft(50);
        if(isHungry()){
            eat();
        }
    }
}