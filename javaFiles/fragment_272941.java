int[][] arr1 = {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}}
int[][] arr2 = new int[2][10];

// ...

for(int n = 0; n < arr1.length; n++) {
    System.arrayCopy(arr1[n], 0, arr2[n], 0, 2);
    System.arrayCopy(arr1[n], 0, arr2[n], 2, 6);
    System.arrayCopy(arr1[n], 4, arr2[n], 6, 2);
}

// here arr2 will have what you want