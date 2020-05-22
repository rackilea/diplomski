long startTime = System.currentTimeMillis();
// Update the game state...
long endTime = System.currentTimeMillis();
long cycle = endTime - startTime;
long delay = MAX_DELAY - cycle;
Thread.sleep(delay); // This might need to be wrapped in a try-catch