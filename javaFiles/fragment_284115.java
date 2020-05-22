private static final String[] resultList;
static {
    List<String> tmpList = new ArrayList<String>(Arrays.asList(DESEASE));
    tmpList.addAll(Arrays.asList(GENE));
    tmpList.addAll(Arrays.asList(GEO));
    resultList = tmpList.toArray(new String[tmpList.size()]);
}