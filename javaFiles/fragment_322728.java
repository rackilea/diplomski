public abstract AbstractParser<T extends Value> {
  private final Class<T> valueType;
  protected T value;

  protected AbstractParser(Class<T> valueType) {
    this.valueType = valueType;
  }

  // Class users will call this method
  public final void parseSomething(Model model) {
    value = valueType.cast(model.getValue());
    onParseSomething(model, value);
  }

  // Class implementors will override/implement this method
  protected void onParseSomething(Model model, T value) {
  }
}


public ConcreteParser extends AbstractParser<ConcreteValue> {

  public ConcreteParser() {
      super(ConcreteValue.class);
  }

  @Override
  public void onParseSomething(Model model, ConcreteValue value) {
  }
}