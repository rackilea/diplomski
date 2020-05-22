public String removePasswordFromJsonString(String jsonString){

  // Handle null input
  if (jsonString == null) {
    return null;
  }

  // Replace all password values with empty strings
  return jsonString.replaceAll(
      "(\\n?\\s*\"password\"\\s?:\\s?\")[^\\n\"]*(\",?\\n?)", "$1$2");

}