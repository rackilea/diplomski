DoubleProperty width = new SimpleDoubleProperty(3);
DoubleProperty height = new SimpleDoubleProperty(4);
ObservableDoubleValue area = Bindings.createDoubleBinding(() -> {
    double a = width.get() * height.get();
    System.out.println("Computed area: "+a);
    return a ;
}, width, height);
System.out.println("Area is "+area.getValue());
width.set(2);
height.set(3);
System.out.println("Area is "+area.getValue());