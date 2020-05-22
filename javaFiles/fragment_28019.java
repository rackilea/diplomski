List<String> input = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O");

List<String> output = new ArrayList<>(input.size());
for (int col = 0; col < 3; col++)
    for (int row = 0; row < 5; row++)
        output.add(input.get(row * 3 + col));

System.out.println(input);
System.out.println(output);