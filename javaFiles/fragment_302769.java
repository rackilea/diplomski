public static void main(String[] args) {
    HashSet<Integer> A = new HashSet<>();
    A.add(2);
    boolean addNumber;
    for (int n = 3; n < 100; n++) {
        addNumber = true;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                addNumber = false;
                break;
            }
        }
        if (addNumber)
            A.add(n);
    }
    System.out.println(A);
}