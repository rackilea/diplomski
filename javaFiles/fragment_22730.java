public class SuperClass {
    private String name;

    public SuperClass setName(String name) {
      this.name = name;
      return this;
    }
}

public class SubClass extends SuperClass {

    @Override
    public SubClass setName(String name) {
       super.setName(name);
       return this;
    }

    public void setId(int i) {
       ...
    }
}