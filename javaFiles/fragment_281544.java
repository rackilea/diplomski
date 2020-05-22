public void LevelContinue() {
    short i;
    int dx = 1;
    int random;

    for (i = 0; i < nrofghosts; i++) {
        ghosty[i] = 4 * blocksize;
        ghostx[i] = 4 * blocksize;
        ghostdy[i] = 0;
        ghostdx[i] = dx;



        dx = -dx;//Line which kills your code



        random = (int)(Math.random() * (currentspeed + 1));
        if (random > currentspeed)
            random = currentspeed;
        ghostspeed[i] = validspeeds[random];
    }