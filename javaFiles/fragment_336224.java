Scanner scanner = new Scanner("0|0.20\n1|0.10\n2|0.20\n");
scanner.useDelimiter(Pattern.compile("[|\n]"));

List<Integer> intList = new ArrayList<>();
List<Double> doubleList = new ArrayList<>();

while (scanner.hasNext()) {
    intList.add(scanner.nextInt());
    doubleList.add(scanner.nextDouble());
}
System.out.println(intList);
System.out.println(doubleList);