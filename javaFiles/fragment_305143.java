while (true) {
    input = scanner.nextLine();
    String[] tokens = input.split(" ");
    String name = tokens[0];
    if ("buy".equals(name)) {
        break;
    }
    double price = Double.parseDouble(tokens[1]);
    double quantity = Double.parseDouble(tokens[2]);
    myMap.computeIfAbsent(name,n -> new HashMap<>())
         .merge(price, quantity, (q1,q2)->q1+q2);
}