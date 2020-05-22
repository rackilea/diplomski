List<List<String>> words = new ArrayList<List<String>>();

while (sc.hasNextLine()) {
    String line = sc.nextLine();
    words.add(Arrays.asList(line.split("\\s+")));
}

for (List<String> list : words) {
    for (int i = list.size()-1; i >= 0; i--)
        System.out.print(list.get(i) + " ");
    System.out.println();
}