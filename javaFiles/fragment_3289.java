List<MyObject> list = new ArrayList<MyObject>();
while (haveMoreEntries()) {
    MyObject obj = new MyObject();
    obj.setName(readName());
    obj.setAddress(readAddress());
    list.add(obj);
}