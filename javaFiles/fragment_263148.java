ImmutableListMultimap.Builder<ENBEquipment, File> builder =
    ImmutableListMultimap.builder();
for (File file : fileList) {
  Matcher m = p.matcher(file.getName());
  if (m.matches()) {
    builder.put(enodebByMacroEnbIdMap.get(m.group(2)), file);
  }
}
ImmutableListMultimap<ENBEquipment, File> mappedFiles = builder.build();