int[] array = new int[]{1, 2, 3};
int i = 0;
while (true) {
    System.out.println(array[i]);  // or anything else
    i = (i + 1) % array.length;
}