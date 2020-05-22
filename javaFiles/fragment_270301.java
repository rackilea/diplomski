Random r = new Random();
int [] array = new int[100];
for (int a = 0; a < array.length; a++) {
    if ((a + 1) % 10 != 0) {
        array[a] = (a + 1) * 10;
    } else {
        array[a] = r.nextInt(1000);
    }
}