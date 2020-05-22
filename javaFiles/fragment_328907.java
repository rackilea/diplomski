public class MyGridDataSource implements GridDataSource {
    private final List list;

    public MyGridDataSource(final Collection collection) {
        assert collection != null;
        list = CollectionFactory.newList(collection);
    }

    public int getAvailableRows() {
        return list.size();
    }

    public void prepare(int startIndex, int endIndex, List<SortConstraint> sortConstraints) {
        for (SortConstraint constraint : sortConstraints) {
            final ColumnSort sort = constraint.getColumnSort();
            if (sort == ColumnSort.UNSORTED) {
                continue;
            }

            final PropertyConduit conduit = constraint.getPropertyModel().getConduit();

            final Comparator valueComparator = new Comparator<Comparable>() {
                public int compare(Comparable o1, Comparable o2) {
                    if (o1 == null) {
                        return 1;
                    }

                    if (o2 == null) {
                        return -1;
                    }

                    String name1 = (String) o1;
                    String name2 = (String) o2;

                    for (int i = 0; i < Math.min(name1.length(), name2.length()); i++) {
                        Character c1 = name1.charAt(i);
                        Character c2 = name2.charAt(i);
                        Character C1 = Character.toUpperCase(c1);
                        Character C2 = Character.toUpperCase(c2);
                        int diff = 0;

                        // if the letters are different and different case, then....
                        // this allows "a" to come before "Z" for instance
                        if (c1.compareTo(c2) != 0 && C1.compareTo(C2) != 0 && 
                                c1.compareTo(c2) != C1.compareTo(C2)) {
                            diff = C1.compareTo(C2);
                        } else {
                            diff = c1.compareTo(c2);
                        }

                        if (diff != 0) {
                            return diff;
                        }
                    }

                    // shorter strings come first
                    return name1.length() - name2.length();
                }
            };

            final Comparator rowComparator = new Comparator() {
                public int compare(Object row1, Object row2) {
                    Comparable value1 = (Comparable) conduit.get(row1);
                    Comparable value2 = (Comparable) conduit.get(row2);

                    return valueComparator.compare(value1, value2);
                }
            };

            final Comparator reverseComparator = new Comparator() {
                public int compare(Object o1, Object o2) {
                    int modifier = sort == ColumnSort.ASCENDING ? 1 : -1;
                    return modifier * rowComparator.compare(o1, o2);
                }
            };

            Collections.sort(list, reverseComparator);
        }
    }

    public Class getRowType() {
        return list.isEmpty() ? null : list.get(0).getClass();
    }

    public Object getRowValue(int index) {
        return list.get(index);
    }

    public List getList() {
        return list;
    }
}