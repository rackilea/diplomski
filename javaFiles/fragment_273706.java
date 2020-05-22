public interface DocParserFactory {
    SnapshotParser<Model1> getModel1Parser();
    SnapshotParser<Model2> getModel2Parser();
    ...
    SnapshotParser<Model1> getModelNParser();
}