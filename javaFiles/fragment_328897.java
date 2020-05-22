private ArrayList<DataObject> mess() {
    ArrayList results = new ArrayList<>();
    for (int index = 0; index < titles.length; index++) {
        DataObject obj = new DataObject(titles[index],
                details[index]);
        results.add(index, obj);
    }
    return results;
}