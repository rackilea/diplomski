public static void writeHashmapToFile(String fileToWrite, HashMap<Integer, String> hashmapToWrite) throws IOException {
    // Using 'Try With Resources'.
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWrite))) {
        int powersOf2 = 2;
        StringBuilder sb;
        for (Object objectName : hashmapToWrite.keySet()) {
            int key = (int) objectName;
            String line = hashmapToWrite.get(key);
            //System.out.println(key + "\t" + line);
            if (key == powersOf2) {
                sb = new StringBuilder();
                sb.append(key).append("\t").append(line).append(System.lineSeparator());
                bw.write(sb.toString());
                powersOf2 *= 2;   // Same as: powersOf2 = powersOf2 * 2
            }
        }
    } 
}