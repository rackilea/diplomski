public final static String CONSTANT_1 = "*value*";
      public final static String CONSTANT_2 = "*value*";
              ...
      public final static String CONSTANT_N = "*value*";

      public final static Set<String> SET_OF_CONSTANTS = Collections.unmodifiableSet(
        new HashSet<String>(Arrays.asList(
              CONSTANT_1, 
              CONSTANT_2,
                      ...
              CONSTANT_N
              )));