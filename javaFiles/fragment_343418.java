int arr3[]= new int[50];
arr3[0] = 1;
arr3[1] = 2;
arr3[2] = 3;
arr3[3] = 4;
arr3[4] = 5;
arr3[5] = 6;
arr3[6] = 7;

for (int i = 7; i < arr3.length; i++) {
    arr3[i] = (int) (Math.random() * 1500);
}