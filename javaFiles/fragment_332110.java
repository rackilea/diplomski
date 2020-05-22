public class XxxToNullMapper implements DataMapper {
    @Override
    public Object[] map(Reader reader) {
        return new BufferedReader(reader).lines()
                .map(line -> line.split(","))
                .map(columns ->
                        Stream.of(columns)
                                .map(column -> column.equals("xxx") ? null : column)
                                .collect(Collectors.toList()).toArray()
                )
                .collect(Collectors.toList()).toArray();
    }
}