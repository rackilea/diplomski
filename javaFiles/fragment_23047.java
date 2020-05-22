final Random rnd = new Random();

for(int decpl = 0; decpl < 3; decpl++){
    for(int low = 0; low < 2; low++){
        for(int high = low + 1; high < low + 3; high++){
            System.out.println("Random Value between " + low + " and "
                + high + " with " + decpl + " decimal places:");
            System.out.println(getRandomValue(rnd, low, high, decpl));
        }
    }
}