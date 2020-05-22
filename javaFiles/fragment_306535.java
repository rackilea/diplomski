Accumulator<Double> accum = sc.accumulator(0d);

objects.map(
  ...
  accum.add(1d)
  ...
)