// The implementation of each getModelXParser method
class DocParserFactoryImpl {

    SnapshotParser<Model1> getModel1Parser() {
        return docSnapshot -> {
            Map<String, Object> data = docSnapshot.getData();
            return new Model(data.getOrDefault("name", "John Doe"))};
    }

    ...

}