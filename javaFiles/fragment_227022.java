public class RuntimeInput {
    private final Map<String, Object> RUNTIME_INPUT;

    private static final String SORTING = "sorting";
    private static final String YAML_PATH = "/src/main/resources/input.yaml";


    public RuntimeInput() {
        RUNTIME_INPUT = getMapFromYaml();
    }

    public static Map<String, Object> getMapFromYaml() {
        Yaml yaml = new Yaml();
        Reader reader = null;
        Map<String, Object> map = null;
        try {
            reader = new FileReader(YAML_PATH);
            map = (Map<String, Object>) yaml.load(reader);
        } catch (final FileNotFoundException fnfe) {
            System.err.println("We had a problem reading the YAML from the file because we couldn't find the file." + fnfe);
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (final IOException ioe) {
                    System.err.println("We got the following exception trying to clean up the reader: " + ioe);
                }
            }
        }
        return map;
    }

    public Map<String, Object> getSortingDataInput() {
        return (Map<String, Object>) RUNTIME_INPUT.get(SORTING);
    }

    public static void main(String args[]) {
        RuntimeInput runtimeInput = new RuntimeInput();
        System.out.println(Arrays.asList(runtimeInput.getSortingDataInput()));
    }
}