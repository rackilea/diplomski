private void organisedRoom() {
    for (int i = customers.length - 1; i > 0; i--) {
        for (int j = 0; j < i; j++) {
            if (customers[j + 1] == null) {
                continue;
            }
            if (customers[j] == null ||customers[j + 1].compareTo(customers[j]) < 0) {
                Customer temp = customers[j + 1];
                customers[j + 1] = customers[j];
                customers[j] = temp;
            }
        }
    }
    System.out.println("show rooms: " + Arrays.toString(customers));
}