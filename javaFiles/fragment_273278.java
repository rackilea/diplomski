public enum StringClassification {
    CONTAINS_HYPHEN, LENGTH_GT_30, DEFAULT;

    public static StringClassification classify(String s) {
      if (s.length() > 30 && s.contains("-")) {
        return StringClassification.CONTAINS_HYPHEN;
      } else if (s.length() > 30) {
        return StringClassification.LENGTH_GT_30;
      } else {
        return StringClassification.DEFAULT;
      }
    }
  }