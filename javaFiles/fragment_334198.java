//random generator
    Random rnd = new Random();

    for (int i = 0; i < xFieldVal; i++) {
        for (int j = 0; j < yFieldVal; j++) {
            //generate new int in interval
            array[i][j] = minArrayVal + rnd.nextInt(maxArrayVal- minArrayVal+ 1);
        }
    }