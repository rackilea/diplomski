RangeSet<Date> rangeSet = TreeRangeSet.create();
rangeSet.add(referenceRange);
for (Range<Date> range : rangesToRemove) {
  rangeSet.remove(range);
}
for (Range<Date> exclusiveRange : rangeSet.asRanges()) {
   ...
}