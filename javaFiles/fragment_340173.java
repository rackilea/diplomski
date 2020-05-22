private static String nameWithoutSuffix(String nameWithSuffix) {
  int periodIndex = nameWithSuffix.indexOf('.');
  int newlineIndex = nameWithSuffix.indexOf('\n');
  if ((periodIndex == -1) && (newlineIndex == -1)) {
    return nameWithSuffix;
  }

  int suffixStartIndex = -1;
  if (periodIndex != -1) {
    suffixStartIndex = periodIndex;
  }
  if ((newlineIndex != -1)
      && ((suffixStartIndex == -1)
          || (newlineIndex < suffixStartIndex))) {
     suffixStartIndex = newlineIndex;
  }

  return nameWithSuffix.substring(0, suffixStartIndex);
}