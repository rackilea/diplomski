Bus bus = BusFactory.getDefaultBus();
MyClass mc = bus.getExtension(MyClass.class);
if(mc == null) {
    mc = new MyClass();
    bus.setExtension(mc, MyClass.class);
}