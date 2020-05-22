String line;

try (
    InputStream fis = new FileInputStream("the_file_name");
    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
    BufferedReader br = new BufferedReader(isr);
) {
    while ((line = br.readLine()) != null) {
        // Do your thing with line
    }
}