int end = 1;
int step = 2;
int rows = 5;

for (int i=0; i<rows; i++) {
    for (int j=0; j<i+1; j++) {
        int number = end + i*step - j*step;
        System.out.print(number + " ");
    }
    System.out.println();
}