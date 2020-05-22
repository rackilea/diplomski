public static void main(String[] args) throws Exception {
    ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
    int n = 3; // number of columns here
    Class[] types = IntStream.range(0, n).mapToObj(i -> String.class).toArray(Class[]::new);
    DataSet<Tuple> csv = readCsv(env, "filename.csv", types);
    csv.print();
}

private static DataSource<Tuple> readCsv(ExecutionEnvironment env, String filename, Class[] fieldTypes) {
    TupleTypeInfo<Tuple> typeInfo = TupleTypeInfo.getBasicAndBasicValueTupleTypeInfo(fieldTypes);
    TupleCsvInputFormat<Tuple> inputFormat = new TupleCsvInputFormat<>(new Path(filename), typeInfo);
    return new DataSource<>(env, inputFormat, typeInfo, Utils.getCallLocationName());
}