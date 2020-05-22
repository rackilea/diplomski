// My random samples
Random random = new Random(0L);

int pathSize = 4;

for (int i = 0; i < 1000; i++) {
    entrances = new int[]{0};
    //Arrays.setAll(entrances, j -> random.nextInt(0+1));

    exits = new int[]{pathSize - 1};
    //Arrays.setAll(exits, j -> random.nextInt(pathSize));

    path = new int[pathSize][pathSize];
    Arrays.setAll(path, j -> IntStream.generate(() -> random.nextInt(20)).limit(pathSize).toArray());

    for (int j = 0; j < path.length; j++) {
        path[j][j] = 0;
    }

    for (int j = 0; j < path.length; j++) {
        for (int k = 0; k < path[j].length; k++) {
            path[j][k] = random.nextDouble() < 0.75 ? 0 : path[j][k];
        }
    }

    try {
        answer(entrances, exits, path);
    } catch (Exception e) {
        System.err.println("[" + String.format("%02d", i) + "] Threw an exception for inputs " + Arrays.toString(entrances) + ", " + Arrays.toString(exits) + ", " + Arrays.deepToString(path));
        e.printStackTrace();
    }
}