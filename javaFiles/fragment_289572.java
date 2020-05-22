Collection<Integer> integers = Arrays.asList(1, 2, 3);
// Shouldn't this be legal? Integer extends Number after all?
Collection<Numbers> numbers = integers;
// I might do this then
numbers.add(2.0);
// Ouch! integers now contains a Double.
for (Integer i : integers) ...