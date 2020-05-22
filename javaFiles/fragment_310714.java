class MyMenu extends Div {
  String item1;
  ...
  public void setItem1(String x){
    item1 = x;
  }

  // onCreate is fired before data is send to the client,
  // but after the Component and all it children exists.
  public void onCreate(CreateEvent ev){
    Executions.CreateComponents("MenuDef.zul", this, new HashMap<String, Object>(){{
        put("item1", item1);
    }});
  }
}