public static void main(String[] args) throws IOException {
    // open stream to path list file
    InputStream indexSource = new FileInputStream("index.txt");

    // create reader to read content
    try(BufferedReader stream = new BufferedReader(new InputStreamReader(indexSource))) {
        // loop
        while (true) {
            // read line
            String line = stream.readLine();
            if (line == null) {
                // stream reached end, escape the loop
                break;
            }
            // use `line`
            printFile(line);
        }
    }
}

static void printFile(String path) throws IOException {
    // open stream to text file
    InputStream textSource = new FileInputStream(path);

    // print file path
    System.out.println("### " + path + " ###");
    // create reader to read content
    try(BufferedReader stream = new BufferedReader(new InputStreamReader(textSource))) {
        // loop
        while (true) {
            // read line
            String line = stream.readLine();
            if (line == null) {
                // stream reached end, escape the loop
                break;
            }
            // print current line
            System.out.println(line);
        }
    }
    // nicer formatting
    System.out.println();
}