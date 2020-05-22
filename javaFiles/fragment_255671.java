public class TypesafeConfigPropertySource extends PropertySource<Config> {
    public TypesafeConfigPropertySource(String name, Config source) {
        super(name, source);
    }

    @Override
    public Object getProperty(String path) {
        if (source.hasPath(path)) {
            return source.getAnyRef(path);
        }
        return null;
    }
}