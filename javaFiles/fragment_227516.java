public static void main(String[] args) throws Exception {
    List<String> file1 = new ArrayList(Arrays.asList("Some", "Simple", "Text", "File"));
    List<String> file2 = new ArrayList(Arrays.asList("Another", "Text", "File", "With", "Additional", "Lines"));

    boolean diff = false;
    int file2Index = 0;
    for (int file1Index = 0; file1Index < file1.size();) {
        if (!file1.get(file1Index).equals(file2.get(file2Index)) && !diff) {
            diff = true;
            // The word from file 1 was changed
            System.out.println("*" + file1.get(file1Index) + "|" + file2.get(file2Index));
            file1Index++;
            file2Index++;
        } else if (!file1.get(file1Index).equals(file2.get(file2Index)) && diff) {
            // This word was removed from file 1
            System.out.println("-" + file1.get(file1Index));
            file1Index++;
        } else {
            System.out.println(file1.get(file1Index));
            diff = false;
            file1Index++;
            file2Index++;
        }
    }

    // Print what's left from file 2
    for (; file2Index < file2.size(); file2Index++) {
        System.out.println("+" + file2.get(file2Index));
    }
}