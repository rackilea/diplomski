public <T> List<T> methodeName(String path, Class<T> clazz) throws FileNotFoundException {
    CSVReader reader = new CSVReader(new FileReader(path), ',', '\"');

    HeaderColumnNameTranslateMappingStrategy<T> strat = 
        new HeaderColumnNameTranslateMappingStrategy<T>();
    strat.setType(clazz);
}

...

ClassName cn = new ClassName();
List<Foo> foos = cn.methodeName(somePath, Foo.class);