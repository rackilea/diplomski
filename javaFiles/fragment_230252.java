public class MyFile {

    private static final Pattern ISDN = Pattern.compile("\\s*ISDN=(.*)");
    private static final String LS = System.getProperty("line.separator");

    public List<String> getISDNsFromFile(final String fileName) throws IOException {

        List<String> ret = new ArrayList<>();
        Matcher m;

        List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        for (String line : lines) {
            m = ISDN.matcher(line);
            if (m.matches())
                ret.add(m.group(1));
        }
        for (int i = 3; i < ret.size(); i+=4)
            ret.add(i, LS);
        return ret;
    }
}