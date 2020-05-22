public class Configuration {
private String name;
private SourceType sourceType;
private List<String> paths = new ArrayList<String>();

public Configuration(String name, SourceType sourceType) {
    super();
    this.name = name;
    this.sourceType = sourceType;
}

public void addPath(String path) {
    paths.add(path);
}

public List<String> getPaths() {
    return paths;
}
}