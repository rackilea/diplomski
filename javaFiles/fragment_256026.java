Vector<Stuff> process(Vector<Stuff> input) {
  Vector<Stuff> output;
  int startIdx = 0;

  while(startIdx < input.size()) {
    int endIdx = Math.min(startIdx + 50000, input.size());
    output.addAll(doStuff(input.subList(startIdx, endIdx)));
    startIdx = endIdx;
  }
}