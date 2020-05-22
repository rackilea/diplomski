public class Main {

    public static void main(String args[]) {

        int temp;

        Scanner sc = new Scanner(System.in);
        int number;
        System.out.println("Enter the number of integers to be sorted - ");
        int input = sc.nextInt();
        int[] carriage;
        carriage = new int[input];
        for (int i = 0; i < input; i++) {
            System.out.println("Enter the "+ i+1 +"number  - ");
            number = sc.nextInt();
            carriage[i] = number;
        }
        int n = carriage.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (carriage[j] < carriage[i]) {
                    temp = carriage[i];
                    carriage[i] = carriage[j];
                    carriage[j] = temp;
                }

            }
            System.out.println(carriage[i] + " ");
        }
        sc.close();
    }
}