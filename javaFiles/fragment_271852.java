// Construction:
ImmutableTable.Builder<String, Long, Long> builder =
    ImmutableTable.builder();
for (RowType row : rows) {
  builder.put(row.getStatus(), row.getHeight(), row.getCount());
} 
ImmutableTable<StatusType, HeightType, CountType> table = builder.build();

// Retrieval:
Long count = table.get("InUse", 90L);