public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
        final int val = i; // temp final variable
        new Thread() {
            public void run() {
                System.out.println(val); //the compiler checks for val (and according to javac rules, val should be  (and it is) final).
            };
        }.start();

    }
}