// Class member variables (possible default values should be considered)...
private static String inputFile = "";              // Input File Path and File Name  [enclosed within quotation marks if whitespaces are in path]
private static String outputFile = "";             // Output File Path and File Name  [enclosed within quotation marks if whitespaces are in path]
private static String compressionType = "";        // Alternatives: HUFFMAN  (-huff) or  LZW        (-lzw).
private static String direction = "COMPRESS";      // Alternatives: COMPRESS (-c)    or  DECOMPRESS (-d).

// The main() method...
public static void main(String args[]) {
    // Process Command-Line Arguments provided in any order...
    for (String argument : args) {
        switch (argument.toLowerCase()) {
            case "-huff":
                compressionType = "HUFFMAN";
                continue;
            case "-lzw":
                compressionType = "LZW";
                continue;
            case "-c":
                direction = "COMPRESS";
                continue;
            case "-d":
                direction = "DECOMPRESS";
                continue;
        }

        // Source (input) and Destination (output) files...
        if (new File(argument).exists() && new File(argument).isFile()) {
            inputFile = argument;
        }
        else {
            outputFile = argument;
        }
    }
    // ------------------------------------------------

    System.out.println();
    System.out.println("Input File:       " + inputFile);
    System.out.println("output File:      " + outputFile);
    System.out.println("Compression Type: " + compressionType);
    System.out.println("Direction:        " + direction);

    // Do what you want with the variables contents ....

}