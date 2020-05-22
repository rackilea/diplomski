char[] arr1 = { 'a', 'a', 'a', 'a', 'b', 'b', 'b', 'b', 'c', 'c', 'c', 'c', 'e', 'e', 'g', 'f', 'h' };

Arrays.sort(arr1);
for (int i = 0; i < arr1.length; i++) {
    char each = arr1[i];
    System.out.print(each);
    if (i + 1 < arr1.length && arr1[i + 1] != each) {
        System.out.println();
    }
}