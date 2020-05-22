public static void main(String... args) throws IOException {
    generateFile("/tmp/DID.txt", 1400000);
    generateFile("/tmp/AllIDs.txt", 16000000);

    long start = System.currentTimeMillis();
    TLongHashSet did = readLongs("/tmp/DID.txt");
    TLongHashSet validIDS = readLongsUnion("/tmp/AllIDs.txt",did);

    long time = System.currentTimeMillis() - start;
    System.out.println("Took "+ time+" ms to find "+ validIDS.size()+" valid ids");
}

private static TLongHashSet readLongs(String filename) throws IOException {
    System.out.println("Reading ids in "+filename);
    BufferedReader br = new BufferedReader(new FileReader(filename), 128*1024);
    TLongHashSet ids = new TLongHashSet();
    for(String line; (line = br.readLine())!=null;)
        ids.add(Long.parseLong(line));
    br.close();
    return ids;
}

private static TLongHashSet readLongsUnion(String filename, TLongHashSet validSet) throws IOException {
    System.out.println("Reading ids in "+filename);
    BufferedReader br = new BufferedReader(new FileReader(filename), 128*1024);
    TLongHashSet ids = new TLongHashSet();
    for(String line; (line = br.readLine())!=null;) {
        long val = Long.parseLong(line);
        if (validSet.contains(val))
            ids.add(val);
    }
    br.close();
    return ids;
}

private static void generateFile(String filename, int number) throws IOException {
    System.out.println("Generating "+number+" ids to "+filename);
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename), 128*1024));
    Random rand = new Random();
    for(int i=0;i<number;i++)
        pw.println(rand.nextInt(1<<26));
    pw.close();
}