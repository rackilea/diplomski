List<List<Integer>> inputs = new ArrayList<List<Integer>>();
input.add(Arrays.asList(0, 1, 2));
input.add(Arrays.asList(0, 1, 2, 3));
input.add(Arrays.asList(0, 1));

MixedRangeCombinationIterable<Integer> product = 
    new MixedRangeCombinationIterable(inputs)

for(List<Integer> combination: product){
    System.out.println(combination)
}