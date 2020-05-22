class Mapping {
    private static java.util.regex.Pattern MAPPING_PATTERN =
            ~/^(?<member>    )?(?<location>\d+:\d+:)?(?:(?<type>.*?) )?(?<name>.*?)(?:\((?<args>.*?)\))?(?: -> )(?<obfuscated>.*?)(?<class>:?)$/;
    private static int MAPPING_PATTERN_OBFUSCATED_INDEX = 6;

    private final File source
    public Mapping(File source) {
        this.source = source
    }

    public void remap(File target) {
        target.withWriter { source.eachLine Mapping.&processLine.curry(it) }
    }

    private static void processLine(Writer out, String line, int num) {
        java.util.regex.Matcher m = MAPPING_PATTERN.matcher(line)
        if (!m.find()) {
            throw new IllegalArgumentException("Line #${num} is not recognized: ${line}")
        }
        try {
            def originalName = m.group("name")
            def obfuscatedName = m.group("obfuscated")
            def newName = originalName.equals(obfuscatedName) ? obfuscatedName : unfuscate(originalName, obfuscatedName)
            out.write(line.substring(0, m.start(MAPPING_PATTERN_OBFUSCATED_INDEX)))
            out.write(newName)
            out.write(line.substring(m.end(MAPPING_PATTERN_OBFUSCATED_INDEX)))
            out.write('\n')
        } catch (Exception ex) {
            StringBuilder sb = new StringBuilder("Line #${num} failed: ${line}\n");
            0.upto(m.groupCount()) { sb.append("Group #${it}: '${m.group(it)}'\n") }
            throw new IllegalArgumentException(sb.toString(), ex)
        }
    }

    private static String unfuscate(String name, String obfuscated) {
        int lastDot = name.lastIndexOf('.') + 1;
        String pkgWithDot = 0 < lastDot ? name.substring(0, lastDot) : "";
        name = 0 < lastDot ? name.substring(lastDot) : name;
        // reassemble the names with something readable, but still breaking changes
        // pkgWithDot will be empty for fields and methods
        return pkgWithDot + '_' + name;
    }
}