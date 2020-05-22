Cd bj = new Cd("basement_jaxx_singles");

List order = new ArrayList();
// adds the same cd twice (two references to the same object)
order.add(bj);
order.add(bj);

// adds itself (cycle)
order.add(order);

XStream xstream = new XStream();
xstream.alias("cd", Cd.class);
System.out.println(xstream.toXML(order));