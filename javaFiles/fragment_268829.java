private void sort2dArray() {
String[][] namesAndDatesList = new String[][] { new String[] { "name1", "05/03/2016 02:11:33" },
    new String[] { "name2", "04/03/2016 02:11:34" }, new String[] { "name3", "04/03/2016 02:11:33" },
    new String[] { "name4", "02/03/2016 02:11:33" }, new String[] { "name5", "05/03/2016 02:11:38" } };

Arrays.sort(namesAndDatesList, new Comparator<String[]>() {

    @Override
    public int compare(String[] o1, String[] o2) {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date d1 = null;
    Date d2 = null;
    try {
        d1 = sdf.parse(o1[1]);
        d2 = sdf.parse(o2[1]);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return d1.compareTo(d2);
    }
});
System.out.println(Arrays.deepToString(namesAndDatesList));
}