List list3 = new List(List.ORDERED);
list3.setFirst(8);
list3.setAlignindent(false);
list3.setPostSymbol(" ");
for (int i = 0; i < 5; i++) {
    list3.add("item");
    List list = new List(List.ORDERED);
    list.setPreSymbol(String.valueOf(8 + i) + "_");
    list.setPostSymbol(" ");
    list.add("item 1");
    list.add("item 2");
    list3.add(list);
}
document.add(list3);