List<Another> setFormats(Map<Another, List<Format>> map) {
    return map.entrySet()
              .stream()
              .map(e -> {
                  e.getKey().setFormatList(e.getValue());
                  return e.getKey();
              })
              .collect(toList());
}

List<IdName> setAnothers(Map<IdName, List<Another>> map) {
    return map.entrySet()
              .stream()
              .map(entry -> {
                  entry.getKey().setAnotherNameList(entry.getValue());
                  return entry.getKey();
              })
              .collect(toList());
}