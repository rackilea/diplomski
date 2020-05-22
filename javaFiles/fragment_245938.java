Scanner sc = new Scanner(System.in);
int numberOfEntries = sc.nextInt(); // defines how big the array should be
String[] array = new String[numberOfEntries];
for (int i = 0; i < numberOfEntries; i++) {
    System.out.println("Enter value " + (i+1));
    String word = sc.next();
    array[i] = word;
}

Arrays.stream(array).collect(Collectors.groupingBy(p -> p, Collectors.counting()))
                .entrySet().stream().forEach(key -> System.out.println(key.getKey() + ": " + key.getValue()));