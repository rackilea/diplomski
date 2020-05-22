MyEnums me = new MyEnums();
  me.addEnum(Foo.class);
  me.addEnum(Bar.class);
  System.out.println(me.parse("Foo.A"));
  System.out.println(me.parse("Bar.E"));
  System.out.println(Arrays.toString(me.parseAll("Foo.B", "Bar.D", "Foo.C")));