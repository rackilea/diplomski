HashMap<Integer, ArrayList<Testdata>> map = new HashMap<Integer, ArrayList<Testdata>>();

// Add all the objects like this
while (...) { // While there are more objects
  Testdata td = ... // Get next object

  List<TestData> list = map.get(td.window);
  if (list == null) {
    list = new ArrayList<Testdata>();
    map.put(td.window, list);
  }

  list.add(td.sequence);
}