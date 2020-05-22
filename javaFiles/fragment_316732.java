public class SorterList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("How many numbers to sort ?");
        int count = scanner.nextInt();
        List<Integer> numbers = new ArrayList<Integer>();
        System.out.println("Enter list of numbers to Sort: ");
        for (int i = 0; i < count; i++) {
            System.out.println("Enter number");
            numbers.add(scanner.nextInt());
        }
        System.out.println("List before sorting..");
        System.out.println(numbers);
        Collections.sort(numbers);
        System.out.println("Sorted list");
        System.out.println(numbers);
    }
}