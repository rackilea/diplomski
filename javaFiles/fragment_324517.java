public class MyReverseEngineeringStrategy extends DelegatingReverseEngineeringStrategy {

    public MyReverseEngineeringStrategy(ReverseEngineeringStrategy delegate) {
        super(delegate);
    }

    @Override
    public String columnToPropertyName( TableIdentifier table,
                                        String column) {
        return column;
    }

    @Override
    public String tableToClassName(TableIdentifier tableIdentifier) {
        final String defaultClassName = super.tableToClassName(tableIdentifier);
        final String packageName = this.extractPackageName(defaultClassName);
        final String className = tableIdentifier.getName();
        final String concatedString = packageName.concat(className);
        return concatedString;
    }

    private String extractPackageName(String defaultClassName) {
        int lastIndex = defaultClassName.lastIndexOf(".");
        final String packageName = defaultClassName.substring(0, lastIndex + 1);
        return packageName;
    }