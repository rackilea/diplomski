class Model {

    private static ObservableList<UpdateObject> modelList = FXCollections.observableArrayList();

    static void add(UpdateObject objectToAdd) {
        modelList.add(objectToAdd);
    }

    static ObservableList<UpdateObject> getModel() {
        return modelList;
    }
}