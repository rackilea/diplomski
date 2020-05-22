// Removes /* from the file
  String change = input.replaceAll("/\\*", "");
  // Removes */ from the file
  String change2 = change.replaceAll("\\*/", "");
  // Removes // from the file
  String change3 = change2.replaceAll("//", "");