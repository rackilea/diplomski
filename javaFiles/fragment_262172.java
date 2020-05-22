List<Integer> ints = Arrays.asList(1, 2, 3, 4);
List<Double> doubles = new ArrayList<Double>(ints.size());

for (Integer i : ints) {
    doubles.add(Double.valueOf(i));
}