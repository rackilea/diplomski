class MyFolder implements Folder<MyDocument, MyFolder> {
    @Override
    public ArrayList<MyDocument> findDocuments() {
        return new ArrayList<>(Collections.singletonList(new MyDocument()));
    }
}

class MyDocument implements Document<MyDocument, MyFolder> {
    @Override
    public MyFolder getFolder() {
        return new MyFolder();
    }
}