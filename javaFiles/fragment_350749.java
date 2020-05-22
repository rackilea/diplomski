List<Integer> ints = new ArrayList<Integer>();
ints.add(Integer.valueOf(1));
List<Number> numbers = ints;// This does not compile! and you will now see why:

numbers.add(new Double(2.3d));// This is valid
Integer i = ints.get(1); // This would be broken then because I expect an Integer but get a Double