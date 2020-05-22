int myCounter;
sychronized (lock) {
    if (counter == 30) counter = 0;
    else { counter++ }
    myCounter = counter; // Make a copy of the shared counter and release the lock
}
// Code to print 'A'+myCounter, or whatrever you want with myCounter. This is your local copy and should be used here