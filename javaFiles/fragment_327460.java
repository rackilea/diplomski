// bad idea
public List<MyObject> getMyObjectList() {
    if (this.myObjects== null) {
        myObjects = new ArrayList<MyObject>(myObjectsMap.values());
    }
    return Collections.unmodifiableList(myObjects );
}