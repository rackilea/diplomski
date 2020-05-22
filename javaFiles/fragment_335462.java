Random random = new Random();
int i, j;
do {
    i = random.nextInt(4);
    j = random.nextInt(4);
} while (i == 0 && j == 0);
int[][] map = new int[4][4];
map[i][j] = 1;