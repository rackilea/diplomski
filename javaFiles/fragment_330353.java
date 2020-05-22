class MyComparator implements Comparator<String, String> {

    public int compare(String o1, String o2){
        return new BigDecimal(o1).compareTo(new BigDecimal(o2));
    }

}
...
Collections.sort(list, new MyComparator());