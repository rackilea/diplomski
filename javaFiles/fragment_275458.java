public class CollatzConjecture {
    private int max;

    public CollatzConjecture() {
        ArrayList<Integer> arr = new ArrayList<Integer>();

        Scanner scan = new Scanner(System.in);

        System.out.print("Type an integer: ");

        int n = scan.nextInt();

        int count = 0;

        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }

            System.out.println(n);

            count++;

            arr.add(n);
        }

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > max) {
                this.max = arr.get(i);
            }
        }

        System.out.println(arr);
        System.out.println("Largest value of n: " + this.max);
        System.out.println("Terminated after " + count + " steps");

        scan.close();
    }

    public static void main(String[] args) {
        new CollatzConjecture();
    }
}