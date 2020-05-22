final InputStream rawIn = new FileInputStream("myfile.txt");
try {
    BufferedReader in = new BufferedReader(
        new InputStreamReader(rawIn, "UTF-8")
    );

    // code

} finally {
    rawIn.close();
}