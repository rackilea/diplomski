private static String getColumns(final List<String> columns) {
    List<String> copy = new ArrayList<String>(columns);
    Collections.shuffle(copy);

    int rNumber = random.nextInt(columns.size());

    List<String> subList = copy.subList(0, rNumber);
    Collections.sort(subList, new Comparator<String>() {

        @Override
        public int compare(String o1, String o2) {
            return columns.indexOf(o1) < columns.indexOf(o2) ? -1 : 1;
        }
    });
    return StringUtils.join(subList, ",");
}