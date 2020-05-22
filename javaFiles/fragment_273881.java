final Reader rawIn = new FileReader("myfile.txt"); // Character encoding??
try {
    BufferedReader in = new BufferedReader(rawIn);

    // code

} finally {
    rawIn.close();
}