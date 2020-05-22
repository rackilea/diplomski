class DecisionMaker {
  static final List<DoublePredicate> P_INDEX_TEST = Arrays.asList(
        x -> x >  5.0,
        x -> x >  10.0,
        x -> x >= 90.0,
        x -> x >= 95.0
  );
  static final List<DoublePredicate> VOLUME_TEST = Arrays.asList(
        x -> x > -10.0,
        x -> x >  -5.0,
        x -> x >=  2.0,
        x -> x >=  5.0
  );
  static final String[][] TABLE = {
        {"Too Low",             "Too Low",          "Possibly OK", "Possibly OK",       "Other - Investigate"},
        {"Too Low",             "Possibly Too Low", "OK",          "OK",                "Possibly Too High"},
        {"Possibly Too Low",    "OK",               "OK",          "OK",                "Possibly Too High"},
        {"Possibly Too Low",    "OK",               "OK",          "Possibly Too High", "Too High"},
        {"Other - Investigate", "Possibly OK",      "Possibly OK", "Too High",          "Too High"},
  };

  static String makeDecision(double pIndex, double volume) {
    int row = (int) P_INDEX_TEST.stream().filter(p -> p.test(pIndex)).count();
    int col = (int) VOLUME_TEST .stream().filter(p -> p.test(volume)).count();
    return TABLE[row][col];
  }
}