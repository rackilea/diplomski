int i = 0;
int l = 0;
while (i < arr.length) {                                // I changed the bound
    if (i == arr.length - 1 || arr[i] > arr[i + 1]) {   // I added a 2nd condition
        if (i != l) {
            printList(arr, l, i + 1);
        }
        l = i + 1;
    }
    i++;
}