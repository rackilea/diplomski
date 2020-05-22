public static void main(String... args) {
    Integer[] arr = new Integer[5];
    Scanner sc = new Scanner(System.in);
    for (int j = 0; j < arr.length;) {
        System.out.println("Enter a number less than 11.");
        Integer i = sc.nextInt();
        if (i < 11 && !Arrays.stream(arr).anyMatch(a -> a == i)) {
            arr[j] = i;
            j++;
        }
    }
    System.out.println("type 1 for ascending and 2 for descending order");
    int choice = sc.nextInt();
    if (choice == 1)
        Arrays.sort(arr);
    else if (choice == 2)
        Arrays.sort(arr, Collections.reverseOrder());
    System.out.println(Arrays.toString(arr));
}