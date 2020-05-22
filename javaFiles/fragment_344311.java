boolean isPossible = true;

if (N % 5 == 0) {
    System.out.println("You need : " + (N / 5) + " bags");
} else {
    int diff = 0;
    for (int i = N; i > 0 && N >= 0; i--) {
        if (N % 5 != 0) {
            diff = N % 5;
            N = N - diff;
        } else {
            if (diff % 3 == 0) {
                System.out.println("You need : " + (N / 5 + diff / 3) + " bags");
                isPossible = true;
                break;
            } else {
                N = N - 5;
                diff = diff + 5; 
            }
        }
    }
}

if (N <= 0 || !isPossible)
    System.out.println(-1);