public static void main(String[] args) throws Exception {
    List<String> vals = new ArrayList<>();
    vals.add("1"); vals.add("2"); vals.add("3");

    // This throws a CME
    for(String s: vals) {
        if("1".equals(s)) {
            vals.remove(s);
        }
    }

    // This would work
    for(Iterator i = vals.iterator(); i.hasNext(); ) {
        if("1".equals(i.next())) {
            i.remove();
        }
    }
}