public class Foo {
  public static class Builder {
    public Foo build() {
      return new Foo(this);
    }

    public Builder setSize(int size) {
      this.size = size;
      return this;
    }

    public Builder setColor(Color color) {
      this.color = color;
      return this;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    // you can set defaults for these here
    private int size;
    private Color color;
    private String name;
  }

  public static Builder builder() {
      return new Builder();
  }

  private Foo(Builder builder) {
    size = builder.size;
    color = builder.color;
    name = builder.name;
  }

  private final int size;
  private final Color color;
  private final String name;

  // The rest of Foo goes here...
}