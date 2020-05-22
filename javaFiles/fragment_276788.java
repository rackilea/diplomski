public class Main {
  public static void main(String[] args) {
    Object[] obj = new Object[3];
    obj[0] = new Integer(10);
    obj[1] = new Long(2346246234634L);
    obj[2] = "Hello";

    Collections.singletonList("mapping.xml");
    DozerBeanMapper mapper = new DozerBeanMapper(Collections.singletonList("mapping.xml"));
    PojoObject pojo = mapper.map(obj, PojoObject.class);
    System.out.println(pojo);
  }

  public static class PojoObject {
    private Integer integer;
    private Long longg;
    private String string;

    public PojoObject() {}

    public Integer getInteger() {
      return integer;
    }

    public void setInteger(Integer integer) {
      this.integer = integer;
    }

    public Long getLongg() {
      return longg;
    }

    public void setLongg(Long longg) {
      this.longg = longg;
    }

    public String getString() {
      return string;
    }

    public void setString(String string) {
      this.string = string;
    }

    @Override
    public String toString() {
      return String.format("Pojo content: %d, %d, %s", integer, longg, string);
    }
  }
}