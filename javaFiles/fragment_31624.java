public static String fileToString(String fileName, String encoding) throws IOException {

    try (
        InputStream is = new FileInputStream(fileName);
        InputStreamReader isr = new InputStreamReader(is, encoding);
        BufferedReader br = new BufferedReader(isr)
    ) {
        StringBuilder builder = new StringBuilder();
        String line = null;
        while ((line = br.readLine()) != null) {
            builder.append(line);
            builder.append(LS);
        }
        return builder.toString();
    }
}