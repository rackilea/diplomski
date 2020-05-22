static List<Integer> createNumbers() {
    System.out.println("createNumbers");
    return Arrays.asList(0, 1, 2);
}

public static void main(String[] args) {
    for (Integer num : createNumbers()) {
        System.out.println(num);
    }
}