int[] hashes = new int[1000];

File file = new File(path);
try (Scanner inputFile = new Scanner (file)) {
    for (int i = 0; inputFile.hasNextLine() && i < hashes.length; i++) {
        text = inputFile.nextLine();
        text = hashing(text);

        hashes[i] = Integer.parseInt(text);
        System.out.println(text);
        System.out.println("####");
        System.out.println(hashes[10]);
    }
}