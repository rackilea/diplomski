final List<Entry<String, Integer>> entries = new ArrayList<>(counts.entrySet());
Collections.sort(entries, new Comparator<Entry<String, Integer>>() {

    @Override
    public int compare(final Entry<String, Integer> o1, final Entry<String, Integer> o2) {
        return Integer.compare(o2.getValue(), o1.getValue());
    }
});
final MessageFormat format = new MessageFormat("{0} has a count of {1,number,integer}");
final Iterator<Entry<String, Integer>> iter = entries.iterator();
final Entry<String, Integer> first = iter.next();
System.out.println(format.format(new Object[]{first.getKey(), first.getValue()}));
while (iter.hasNext()) {
    final Entry<String, Integer> entry = iter.next();
    if (entry.getValue() != first.getValue()) {
        break;
    }
    System.out.println(format.format(new Object[]{entry.getKey(), entry.getValue()}));
}