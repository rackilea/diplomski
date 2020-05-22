outterloop:
for (int i = 0; i < 10; i++) {
    for (int j = 0; j < 10; j++) {
        // this would break the inner loop and go to the next outter loop iteration
        // break; 

        // this would break the outter loop, thus exiting both loops
        // break outterloop; 

        // this would jump to the next inner loop iteration
        // continue; 

        // this would jump to the next outter loop iteration, exiting the inner loop
        // continue outterloop; 
    }
}