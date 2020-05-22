private static short[] scanMapFile(String path, int[] leftChunkSides, int[] rightChunkSides) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File(path));
    scanner.useDelimiter(", ");

    short[] tmpMap = new short[chunkWidth * chunkHeight];
    int count = 0;

    while(scanner.hasNext()){
        tmpMap[count] = scanner.nextShort();    
        count++;
    }

    scanner.close();
    return tmpMap;
}