public static String fileToString(String fileName, String encoding) throws IOException {
    InputStream is = null;
    InputStreamReader isr = null;
    BufferedReader br = null;

    try {
        is = new FileInputStream(fileName);
        isr = new InputStreamReader(is, encoding);
        br = new BufferedReader(isr)
        StringBuilder builder = new StringBuilder();
        String line = null;
        while ((line = br.readLine()) != null) {
            builder.append(line);
            builder.append(LS);
        }
        br.close();
        return builder.toString();
    }
    finally {
        IOUtils.closeQuietly(br, isr, is);
    }
}