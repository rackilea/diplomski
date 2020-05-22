ArrayList<Integer> allSums = new ArrayList<>();
ArrayList<List<Integer>> allLists = new ArrayList<>();
for (File f : folder.listFiles()) {

    BufferedReader br = new BufferedReader(new FileReader(path + "\\" + f.getName()));
    Scanner scanner = new Scanner(br);
    ArrayList<Integer> list = new ArrayList<Integer>();
    while (scanner.hasNext()) {
        list.add(scanner.nextInt());
    }
    // Store each read list into a container for all of the lists
    allLists.add(list);
    System.out.println(list);
}

// Assuming all lists are the same size
final int listLength = allLists.get(0).size();
// Iterate over each index
for (int i = 0; i < listLength; i++) {
    int sum = 0;
    // For each index, add the element from that index in each list
    for (List<Integer> list : allLists) {
        sum += list.get(i);
    }
    // Add the current indexes sum to the final list
    allSums.add(sum);
}
// allSums contains the sum from every index

// Using Java 8 streams
allSums.clear();
IntStream.range(0, listLength)
        .forEach((i) -> allSums.add(i, allLists.stream().collect(Collectors.summingInt((c) -> c.get(i)))));
System.out.println(allSums);