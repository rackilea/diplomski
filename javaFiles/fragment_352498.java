Random random = new Random();
int a = 0;
while (a < 3) {
    int i = random.nextInt(array.length);
    int j = random.nextInt(array[0].length);
    if(array[i][j] != 0) {
        array[i][j] = 0;
        a++;
    }
}