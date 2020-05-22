private static final Pattern ISDN = Pattern.compile("ISDN=(.*)");

// ...

public List<String> getISDNsFromFile(final String fileName)
    throws IOException
{
    final Path path = Paths.get(fileName);
    final List<String> ret = new ArrayList<>();

    Matcher m;
    String line;

    try (
        final BufferedReader reader
            = Files.newBufferedReader(path, StandardCharsets.UTF_8);
    ) {
        while ((line = reader.readLine()) != null) {
            m = ISDN.matcher(line);
            if (m.matches())
                ret.add(m.group(1));
        }
    }

    return ret;
}