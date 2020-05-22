List<Double> l = new ArrayList<Double>();
l.add(Double.NaN);
if (l.contains(Double.NaN)) {
    // this wont be executed.
}

Map<Object,String> m = new HashMap<Object,String>();
m.put(Double.NaN, "Hi mum");
if (m.get(Double.NaN) != null) {
    // this wont be executed.
}