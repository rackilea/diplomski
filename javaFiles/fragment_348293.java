List<String> list = new ArrayList<String>();

list.add("s1");
list.add("s2");

ObservableList<String> observableList = FXCollections.observableList(list);

observableList.addListener(new ListChangeListener<String>() {
    @Override
    public void onChanged(Change<? extends String> change) {
        while (change.next()) {
            if(change.wasAdded()){
                System.out.printf("added: %s, from: %d, to: %d%n", change.getAddedSubList(), change.getFrom(), change.getTo());
            }else
            if(change.wasReplaced()){
                System.out.printf("replaced: %s, from: %d, to: %d%n", change.getAddedSubList(), change.getFrom(), change.getTo());
            }
        }
    }
});

observableList.add("s3");
observableList.set(1, "s1-new-value");