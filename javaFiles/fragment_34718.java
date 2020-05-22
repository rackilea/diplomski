private static final List<Validator> validators = Arrays.asList(
  new Validator() {
    @Override
    public String validate() {
      /* do something */
    }
  },
  new Validator() {
    @Override
    public String validate() {
      /* do something else */
    }
  },
  new Validator() {
    @Override
    public String validate() {
      /* do something still else */
    }
  }
);
// Can be written more compactly if in Java 8.