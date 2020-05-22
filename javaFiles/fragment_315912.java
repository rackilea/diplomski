List<List<Double>> myList = new ArrayList<List<Double>>();

List<Double> nested;

nested = new ArrayList<Double>();
nested.add(1);
nested.add(2);
nested.add(3);
myList.add(nested);

nested = new ArrayList<Double>();
nested.add(4);
nested.add(5);
nested.add(6);
myList.add(nested);