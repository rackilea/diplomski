public static class Bar
  {
    private String Z;
    private String W;

    public String getZ()
    {
      return Z;
    }

    public void setZ(String z)
    {
      Z = z;
    }

    public String getW()
    {
      return W;
    }

    public void setW(String w)
    {
      W = w;
    }
  }

  @Test
  public void shouldMapHashMapToFoo()
  {
    HashMap<String, String> map = new HashMap<>();
    map.put("z", "aaaa");
    map.put("w", "bbbb");

    Bar bar = modelMapper.map(map, Bar.class);

    PropertyMap<Bar, Foo> barToFooMap = new PropertyMap<Bar, Foo>()
    {
      @Override
      protected void configure()
      {
        map().setA(source.getZ());
        map().setB(source.getW());
      }

    };
    modelMapper.addMappings(barToFooMap);

    Foo foo = modelMapper.map(bar, Foo.class);

    Assert.assertEquals(foo.getA(), map.get("z"));
    Assert.assertEquals(foo.getB(), map.get("w"));
  }