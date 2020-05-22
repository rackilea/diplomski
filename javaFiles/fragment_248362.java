private final List<List<String>> matrix;
private final String SEPARATOR = "\t";
private final String END_OF_LINE = "\n";

public TSVFormatter(List<List<String>> matrix) {
    this.matrix = matrix;
}

public String doParse() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < matrix.size(); i++) {
        for (int o = 0; o < matrix.get(i).size(); o++) {
            sb.append(matrix.get(i).get(o));
            if (o <( matrix.get(i).size()-1))
                sb.append(SEPARATOR);
            else
                sb.append(END_OF_LINE);
        }
    }
    return sb.toString();
}