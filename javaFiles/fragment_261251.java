int arr1[] = { 20, 65, 23056, 67, 678 };
int arr2[] = { 76, 23, 4545, 98, 90909 };

int len = arr1.length > arr2.length ? arr1.length : arr2.length;
int max = 0;
for (int i = 0; i < len; i++) {
    if (arr1.length > i && arr1[i] > max) {
        max = arr1[i];
    }
    if (arr2.length > i && arr2[i] > max) {
        max = arr2[i];
    }
}

System.out.print("max element is:" + max);```