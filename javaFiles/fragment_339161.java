public static ObservableList<Double> load(String fileName) throws Exception {
    try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
        List<Double> list = (List<Double>) ois.readObject();
        return FXCollections.observableList(list);
    }
}