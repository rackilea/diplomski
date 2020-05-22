public static void main(String[] args) throws Exception {
    String[] arIndex = new String[] {"the", "the", "1", "2", "Hello", "hello", "2"};

    List<String> removedDuplicates = new ArrayList<>();
    for (String arIndex1 : arIndex) {
        if(!removedDuplicates.contains(arIndex1)) {
            removedDuplicates.add(arIndex1);
        }
    }

    // Setting the removedDuplicates to arIndex
    arIndex = new String[removedDuplicates.size()];
    removedDuplicates.toArray(arIndex);
    System.out.println(Arrays.toString(arIndex));
}