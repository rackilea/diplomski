String line;

try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("the_file_name"), Charset.forName("UTF-8")))) {
    while ((line = br.readLine()) != null) {
        // Do your thing with line
    }
}