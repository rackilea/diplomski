public static void main(String[] args) {

  BaseClass c1 = new BaseClass();
  ExtendedClass1 e1 = new ExtendedClass1();
  e1.total = 100L;
  e1.number = 5L;
  ExtendedClass2 e2 = new ExtendedClass2();
  e2.total = 200L;
  e2.x = 5;
  BaseClass c2 = new BaseClass();

  c1.list.add(e1);
  c1.list.add(e2);
  c1.list.add(c2);


  List<BaseClass> al = new ArrayList<BaseClass>();

  // this is the instance of BaseClass before serialization
  System.out.println(c1);

  GsonBuilder gb = new GsonBuilder();

  gb.registerTypeAdapter(al.getClass(), new CustomDeserializer());
  gb.registerTypeAdapter(al.getClass(), new CustomSerializer());
  Gson gson = gb.create();

  String json = gson.toJson(c1);
  // this is the corresponding json
  System.out.println(json);

  BaseClass newC1 = gson.fromJson(json, BaseClass.class);

  System.out.println(newC1);

}