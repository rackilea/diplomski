abstract class SuperClass {

    public abstract SuperClass deepCopy();
  }

  class SubClass extends SuperClass {

    private String value;

    public SubClass(String value) {
      this.value = value;
    }

    @Override
    public SubClass deepCopy() {
      return new SubClass(this.value);
    }
  }