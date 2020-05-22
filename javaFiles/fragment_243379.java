FileManager fileManager = new FileManager();

bookListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String book = String.valueOf(parent.getItemAtPosition(position));
        File file = new File (path + "/" + book);
        fileManager.setFile(file);
        mQuickAction.show(view);
        return true;
    }
});