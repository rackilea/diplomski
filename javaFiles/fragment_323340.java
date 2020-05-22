JCodeModel cm = new JCodeModel();
x = cm._class("foo.bar.Car");
x.field(Engine.class, "engine");
for (PropertyDescriptor pd:    Introspector.
              getBeanInfo(Vehicle.class).getPropertyDescriptors()) {
    g = x.method(JMod.PUBLIC, cm.VOID, pd.getReaderMethod().getName()); 
    g.body()...
    s = x.method(JMod.PUBLIC, cm.VOID, "set" + pd.getName());
    s.body()...
}
hc = x.method(JMod.PUBLIC, cm.VOID, "hashCode"));
hc.body()...
cm.build(new File("target/generated-sources"));