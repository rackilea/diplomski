public static class ComplexType {
  @Component(ordinal = 0)
  String val1;
  @Component(ordinal = 1)
  String val2;
  @Component(ordinal = 2)
  int timestamp;

  // get/set methods left out...
}

private static final AnnotateCompositeSerializer<ComplexType> complexTypeSerializer = new AnnotatedCompositeSerializer<>(ComplexType.class);

public void upsertAttributes(final String rowKey, final Map<String, String> attributes,  final String columnFamily) {

  try {
      MutationBatch m = CassandraAstyanaxConnection.getInstance().getKeyspace().prepareMutationBatch();

      ComplexType ct = createComplexTypeFromAttributes(attributes);

      ColumnListMutation<String> mutation = m.withRow(CassandraAstyanaxConnection.getInstance().getEmp_cf(), rowKey);
    mutation
          .putColumn("lmd", ct, complexTypeSerializer, null);

    m.setConsistencyLevel(ConsistencyLevel.CL_ONE).execute();

} catch (ConnectionException e) {
        // log here
} catch (Exception e) {
        // log here
}
}