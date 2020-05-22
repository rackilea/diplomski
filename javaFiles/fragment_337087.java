public static void waitUntilAllUpright() throws InterruptedException {
    for (;;) { // forever loop
        boolean allUpright = true;
        for (i = 0; i < bots; i++) {
            if (! theBots[i].isUpright()) {
                allUpright = false;
                break;
            } 
        }
        if (allUpright)
            return;
        System.out.println("Please ensure I'm upright");
        Thread.sleep(500); 
    } // loop back to check all bots again
}