class Range {
  static Range NONE = new Range(Double.NaN, Double.NaN);

  final double min, max;

  static Range of(double min, double max) {
    if(Double.isNaN(min) || Double.isNaN(max) || min>max) {
      throw new IllegalArgumentException();
    }
    return new Range(min, max);
  }

  private Range(double min, double max) {
    this.min = min;
    this.max = max;
  }

  boolean contains(double value) {
    return this!=Range.NONE && min<=value && max>=value;
  }

  boolean spans(Range other) {
    return this==other
      || other==Range.NONE
      || (contains(other.min) && contains(other.max));
  }

}

Range range = streamOfDoubles.reduce(
    Range.NONE,
    (range, value) -> {
      if(range==Range.NONE)
        return Range.of(value, value);
      else if(range.contains(value))
        return range;
      else
        return Range.of(Math.min(value, range.min), Math.max(value, range.max));
    },
    (a, b) -> {
      if(b.spans(a))
        return b;
      else if(a.spans(b))
        return a;
      else
        return Range.of(Math.min(a.min, b.min), Math.max(a.max, b.max));
    }
);