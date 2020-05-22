long globalStartTime = System.nanoTime();
    float currentTime = 0;
    while ( currentTime < 10){
         currentTime = (System.nanoTime() - globalStartTime) /  1000000000f;
        System.out.println(currentTime);
    }