final Collator ignoreCase = Collator.getInstance();
ignoreCase.setStrength(Collator.SECONDARY);

List<String> list = Arrays.asList("Chicken", "Duck");
Set<String> set=  new TreeSet<String>(new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        return ignoreCase.compare(o1, o2);
    }
});
set.addAll(list);
System.out.println(set.contains("Chicken"));
System.out.println(set.contains("chicken"));