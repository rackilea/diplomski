List<Object> arr = new ArrayList<Object>();
Scanner scan = new Scanner(System.in);
while (scan.hasNextLine()) {
    String line = scan.nextLine();
    try {
        Integer v = Integer.valueOf(line.trim());
        arr.add(v);
        continue;
    } catch (NumberFormatException nfe) {
    }
    try {
        Double d = Double.valueOf(line.trim());
        arr.add(d);
        continue;
    } catch (NumberFormatException nfe) {
    }
    arr.add(line);
}
for (int i = arr.size() - 1; i >= 0; i--) {
    Object obj = arr.get(i);
    Class<?> type = obj.getClass();
    System.out.printf("%s: %s%n", type.getName(), obj.toString());
}