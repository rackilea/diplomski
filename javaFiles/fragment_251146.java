List<MyObj> list = new ArrayList<>();
if (outputs!= null) { 
  int len = outputs.length();
  for (int i=0; i<len; i++) { 
    JSONObject o = (JSONObject) outputs.get(i);
    list.add(new MyObj(o.getString('name'), o.getString('URL')));
  } 
} 
System.out.println("There is " + list.size() + " objects.");


public static final class MyObj {
  final String name;
  final String url;

  public MyObj(String name, String url) {
     this.name = name;
     this.url  = url;
  }
}