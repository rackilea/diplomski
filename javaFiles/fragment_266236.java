public static void main(String[] args) throws Exception {
    List<String> items = Arrays.asList("/ele1/*", "/ele1/subele1/*" ,"/ele2/subele2/*", "/ele2/*");
    Collections.sort(items, new MinLengthComparator());
    System.out.println(items);
}

private static class MinLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}