final static Pattern PATTERN = Pattern.compile("(.*?)(?:\\((\\d+)\\))?(\\.[^.]*)?");

String getNewName(String filename) {
    if (fileExists(filename)) {
        Matcher m = PATTERN.matcher(filename);
        if (m.matches()) {
            String prefix = m.group(1);
            String last = m.group(2);
            String suffix = m.group(3);
            if (suffix == null) suffix = "";

            int count = last != null ? Integer.parseInt(last) : 0;

            do {
                count++;
                filename = prefix + "(" + count + ")" + suffix;
            } while (fileExists(filename));
        }
    }
    return filename;
}