MyObject obj = new MyObject();
List<MyObject> list = new ArrayList<MyObject>();
while (haveMoreEntries()) {
    obj.setName(readName());
    obj.setAddress(readAddress());
    list.add(obj);
}