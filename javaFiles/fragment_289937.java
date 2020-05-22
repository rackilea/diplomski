public static void main(String args[]){
    Main m = new Main();
    Row r1 = m.new Row(1,1,2);
    Row r2 = m.new Row(2,3,4);
    Row r3 = m.new Row(1,1,2);
    Row r4 = m.new Row(2,3,2);

    Set<Row> set = new HashSet<>();
    set.add(r1);
    set.add(r2);
    set.add(r3);
    set.add(r4);

    for (Row row : set) {
        System.out.println(row.getCol1() + ":" + row.getCol2() + ":" + row.getCol3());
    }
}