public static void sortSizeable(List<String> beanz) {
    Collections.sort(beanz);
    int cols = (int) Math.ceil(Math.sqrt(beanz.size()));
    String[][] sortedBeanz = new String[cols][cols];
    for (int i = 0; i < beanz.size(); i++) {
        int row = i / cols;
        int col = i % cols;
        sortedBeanz[col][row] = beanz.get(i);
    }
    System.out.println(Arrays.stream(sortedBeanz)
            .map(array -> Arrays.stream(array).collect(StringBuilder::new, (sb, s) -> sb.append(s == null ? "=" : s).append(" "), (sb, s) -> {} ))
            .collect(Collectors.joining("\r\n")));
}