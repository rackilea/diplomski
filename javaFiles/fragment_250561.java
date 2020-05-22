double max = Double.MIN_VALUE;
double min = Double.MAX_VALUE;

for (int i = 0; i < map.length; i++) {
    for (int j = 0; j < map[0].length; j++) {
        double p = perlinNoise(((double) i) / 10, ((double) j) / 10, grid);
        map[i][j] = p;
        max = (max < p) ? p : max;
        min = (min > p) ? p : min;
    }
}

for (int i = 0; i < map.length; i++) {
    for (int j = 0; j < map[0].length; j++) {
        map[i][j] = (map[i][j] - min) / (max - min); //Limit 0 to 1
    }
}