private static final int BUFFER_SIZE = 256;
private char[] arr = new char[BUFFER_SIZE];

@Benchmark
public int readArrayTest() throws IOException, InterruptedException {
    clearFileCaches();
    int result = 0;
    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
        int charsRead;
        while ((charsRead = reader.read(arr)) != -1) {
            for (int i = 0; i < charsRead; i++) {
                result += arr[i];
            }
        }
    }
    return result;
}