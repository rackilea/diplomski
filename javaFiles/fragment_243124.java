long timeSinceLastInput = System.currentTimeMillis() - lastInputTime;    
long threshold = 120000;

if (timeSinceLastInput >= threshold) {
    System.exit(0); // You should prefer exiting gracefully here
}