List<Integer> l = Arrays.asList(1, 2, 182938, 1293);
Integer min = Integer.MAX_VALUE;

for (Integer i : l) { 
     min = Math.min(min, i);
}