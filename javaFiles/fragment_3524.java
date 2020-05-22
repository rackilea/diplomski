class FluentGetter {
  private final String name;
  private IEffect found;

  FluentGetter(String name) { this.name = name; }

  <T extends Enum<T> & IEffect> FluentGetter search(Class<T> clazz) {
    if (found == null) { // If you've already found something, don't overwrite that.
      try {
        found = Enum.valueOf(clazz, name);
      } catch (IllegalArgumentException e) {}
    }
    return this;
  }

  IEffect get() {
    return found;  // + check if it's null, if you want.
  }
}