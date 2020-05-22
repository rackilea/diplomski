Message fillAllFields(Message prototype) {
  Message.Builder builder = prototype.newBuilderForType();
  for (FieldDescriptor field: builder.getDescriptorForType().getFields()) {
    builder.setField(field, prototype.getField(field));
  }
  return builder.build();
}