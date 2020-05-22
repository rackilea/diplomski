// Generate random bit either a 0 or a 1
int bit = RandInt(0,1)

// Assume first bit was correct
bool bPreviousWasCorrect = false;

Loop 1 million times
    double probBitIsCorrect = RandUnif(0,1) // get a random number between 0 and 1
    if bPreviousWasWrong then
        // if an error has occured then a 2nd error occurs with prob 0.3
        if (probBitIsCorrect < 0.3)  then
           Set bPreviousWasWrong to true
           increment number of wrong bits
        else
           Set bPreviousWasWrong to false
           increment number of correct bits
        end if
    else
        if (probBitIsCorrect < 0.1)  then
           Set bPreviousWasWrong to true
           increment number of wrong bits
        else
           Set bPreviousWasWrong to false
           increment number of correct bits
        end if

Display results when done