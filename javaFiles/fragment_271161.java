public String binaryFile2(File file) {
    StringBuilder sb = new StringBuilder();
    int counter = 0;
    try (InputStream is = new FileInputStream(file)) {
        int b;
        while ((b = is.read()) != -1) {
            counter++;
            String s = Integer.toHexString(b).toUpperCase();
            if (s.length() == 1) {
                sb.append('0');
            }
            sb.append(s);
            if (counter % 5 == 0) {
                sb.append(System.lineSeparator());
                counter = 0;
            } else {
                sb.append(' ');
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return sb.toString();
}