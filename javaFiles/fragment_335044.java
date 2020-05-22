class MyObjectComp implements Comparator<MyObject> {

    @Override
    public int compare(MyObject o1, MyObject o2) {
        return o1.getInt() - o2.getInt();
    }

}

SortedSet<MyObject> objectSet = new TreeSet<MyObject>(new MyObjectComp());
Myobject newObject = new MyObject(95);
objectSet.add(newObject);