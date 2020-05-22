class driver {
    public static void main(String [] args) {
        int a; 
        int b = 0;
        int c = 1;
        int sum = 0;

        for (int i = 0; i < 10; i++) { // Finds fibonacci sequence
            a = b;
            b = c;
            c = a + b;

            if (c % 2 == 0)  // Check if it's even
                sum += c;
        }
        System.out.println(sum);
    }
}