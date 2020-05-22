for (int i=0; i< 40 ; i++)
{
    // Initializers for this one file
    List<String> strings = new ArrayList<>();
    List<Integer> nums = new ArrayList<>();
    int lineCount = 0;

    String filename = "t" + i;

    try (Scanner s = new Scanner(new FileReader("file/path/" + filename + ".txt"))) {

        while (s.hasNext()) {
            strings.add(s.next());
            if (s.hasNextInt()) {
                nums.add(s.nextInt());
            }
            lineCount++;
        }
    }

    func1(strings,nums,lineCount);
}