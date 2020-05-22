public static void main(String[] args) throws Exception {
    final String input = "{{\"12\",\"13\",\"2\",\"5\"},{\"14\",\"14\",\"1\",\"4\"},{\"36\",\"30\",\"1\",\"9\"}}";
    final String[] rows = input.replaceAll("^\\{\\{|}}$", "").split("},\\{");
    final String[][] transformed = new String[rows.length][];
    for (int i = 0; i < rows.length; ++i) {
        final String[] columns = rows[i].replaceAll("^\"|\"$", "").split("\",\"");
        transformed[i] = new String[columns.length];
        System.arraycopy(columns, 0, transformed[i], 0, columns.length);
    }
    System.out.println(Arrays.deepToString(transformed));
}