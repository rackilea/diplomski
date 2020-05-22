public static int[] initialize() {
    return new int[100];
}

public static void print(int[] data) {
    System.out.println(Arrays.toString(data));
}

public static void main(String[] args) {
    int data[];
    Main.print(data); // compile error - data is not initialized
    data = Main.initialize(); 
}