public void print() {
    for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
        if (i % 10 == 9) {
            System.out.println();
        }
    }
}