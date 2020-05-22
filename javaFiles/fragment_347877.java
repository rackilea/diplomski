DummyContainer container = ...;
  DummyObject a = new DummyObject("qw", "k", 12);
  initAndAddDummyObject(a, container,"sdfs",true);
     ...
  DummyObject b = new DummyObject("qwe", "sd", 8);
  initAndAddDummyObject(b, container,"a4rhs", true);

     ...

 public void initAndAddDummyObject(DummyObject source, DummyContainer container,  String initString, boolean initBoolean){ 
        source.init(initString, initBoolean);
        container.addDummy(source);
    }