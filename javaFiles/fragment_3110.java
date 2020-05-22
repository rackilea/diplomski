public void print() {
    for (int i = 0; i < arr.length / 10; i++) {
        for (int j = 0; j < 10; j++) {
            System.out.print(arr[i * 10 + j] + " ");
        }
        System.out.println();
    }

}