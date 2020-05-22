public static class MappedEnum<E extends Enum<E>> extends TreeMap<String, String> {
  public MappedEnum(EnumSet<E> e) {
    // Whatever you like with the set.
  }

  public void method(E e) {
  }

}

public static class Foo extends MappedEnum<Foo.Tables> {
  public enum Tables {
    table1, table2, table3;
  }

  public Foo() {
    super(EnumSet.allOf(Tables.class));
  }

  @Override
  public void method(Foo.Tables e) {
  }

}