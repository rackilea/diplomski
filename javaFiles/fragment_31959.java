Random rand = new Random();
    int n = rand.nextInt(3);
    n += 1;
    while (n == oldValue) {
        n = rand.nextInt(3);
        n += 1;
    }
    switch (n){
    ...
    }
    oldValue = n; //The oldValue should be global