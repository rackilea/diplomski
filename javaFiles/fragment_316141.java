Scanner sc = new Scanner("12+3 - 456").useDelimiter("\\b");
while (sc.hasNext()) {
    if (sc.hasNextInt()) {
        int num = sc.nextInt();
        System.out.printf("Got an int [%s]%n", num);
    } else {
        String op = sc.next().trim();
        System.out.printf("Got an op [%s]%n", op);
    }
}