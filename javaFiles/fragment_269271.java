try {
    Composite key = new Composite();
    key.addComponent("key1", strSerializer);
    key.addComponent("null", strSerializer);
    compMutator.addInsertion(key, "columnfamily", HFactory.createColumn("column1", "col2 value",HFactory.createClock(), strSerializer,strSerializer));
    compMutator.execute();
} catch (HectorException e) {
    e.printStackTrace();
}