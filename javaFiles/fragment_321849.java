public int[] get_numbers() {
    System.out.println("Please enter numbers for array :");
    int size = keyboard.nextInt();
    int[] values = new int[size];   // create a new array with the given size
    for (int i = 0; i < size; i++) {
        values[i] = keyboard.nextInt();
    }
    System.out.println("There are "+((values.length))+ " numbers in array");
    this.arr = values;
    return this.arr;
}