static List<Integer> myArray = new ArrayList<>();
static List<Integer> evenArray = new ArrayList<>();
static List<Integer> oddArray = new ArrayList<>();

public static void randommethod() {
    Random rand = new Random();
    for (int i = 0; i < 100; i++) {
        int n = rand.nextInt(26); // <-- n + 0 is n. 0 to 25.
        myArray.add(n);
        if (n % 2 == 0) { // <-- test n, no need to get it again.
            evenArray.add(n);
        } else {
            oddArray.add(n);
        }
    }
}