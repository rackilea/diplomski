public String getGh {
  // Just return Gh value
  return Gh;
}

public String setGh(String value) {
  // If Gh is null or empty, assign "AAAAA"; empty otherwise
  Gh = (null == value || 0 == value.length()) 
    ? "AAAAA
    : value;
}