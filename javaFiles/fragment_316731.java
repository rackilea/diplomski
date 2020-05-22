public class Sorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("How many numbers to sort ?");
        int count = scanner.nextInt();
        int numbers[] = new int[count];
        System.out.println("Enter list of numbers to Sort: ");
        for (int i = 0; i < count; i++) {
            System.out.println("Enter number");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("List before sorting..");
        for (int i = 0; i < count; i++) {
            System.out.println(numbers[i]);
        }
        Arrays.sort(numbers);

        System.out.println("Sorted list");
        for (int i = 0; i < count; i++) {
            System.out.println(numbers[i]);
        }
    }
}