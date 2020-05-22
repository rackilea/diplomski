List<XYDataItem> list1 = one.getItems();
List<XYDataItem> list2 = two.getItems();
for (XYDataItem i : list1) {
    for (XYDataItem j : list2) {
        if (i.equals(j)) {
            System.out.println(i);
        }
    }
}