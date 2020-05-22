List<List<Pair>> inputs; // in whatever format you have them
List<List<Pair>> uniqued = new ArrayList<>(); // output to here
Set<String> seen = new HashSet<String>();
for (List<Pair> list : inputs) {
  List<Pair> output = new ArrayList<>();
  for (Pair p : list)
    if (seen.add(p.getName()))
      output.add(p);
  uniqued.add(output);
}