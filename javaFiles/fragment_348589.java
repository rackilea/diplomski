boolean foundCollision;
int numTries = 0;
int maxTries = 1000000;
do {
    foundCollision = false;
    for (int i = 0; i < balls.length; ++i) {
        Ball b1 = balls[i];
        for (int j = i+1; j < balls.length; ++j) {
           Ball b2 = balls[j];
           if (b1.intersects(b1, b2)) {
               foundCollision = true;
               // resolve collision...
        }
    }
    ++numTries;
} while (foundCollision && numTries < maxTries);
if (numTries >= maxTries)
    System.err.println("Couldn't sort out balls after " + maxTries + "tries: what now?");