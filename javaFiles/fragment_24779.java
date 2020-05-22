Vector g = new Vector();
List list = new ArrayList();
list.add(1.0f);
g.add(list);

Vector<List<String>> grid = g; // incorrect cast, but only a warning.
String s = g.elementAt(0).get(0); // throws a class cast exception.