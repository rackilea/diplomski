List<List<String>> original = null;
List<? extends List<?>> ok  = original; // This works
List<?> ok2                 = original; // So does this
List<List<?>> notOk         = original; // This doesn't

List<Integer> original      = null;
List<? extends Number> ok   = original; // This works
List<?> ok2                 = original; // So does this
List<Number> notOk          = original; // This doesn't