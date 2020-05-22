DoubleProperty v1 = new SimpleDoubleProperty();
DoubleProperty v2 = new SimpleDoubleProperty();
StringExpression sb = Bindings.format("%,.3f", v1.add(v2));
System.out.println(sb.get());
sb.addListener((a, b, newValue) -> System.out.println(newValue));
v1.set(3);
v2.set(5.5);