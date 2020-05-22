if (range.hasLowerBound()) {
  if (range.hasUpperBound()) {
    return set.subSet(
      range.lowerEndpoint(),
      range.lowerBoundType() == BoundType.CLOSED,
      range.upperEndpoint(),
      range.upperBoundType() == BoundType.CLOSED);
  } else {
    return set.tailSet(
      range.lowerEndpoint(),
      range.lowerBoundType() == BoundType.CLOSED);
  }
} else {
  if (range.hasUpperBound()) {
    return set.headSet(
      range.upperEndpoint(),
      range.upperBoundType() == BoundType.CLOSED);
  } else {
    return set;
  }
}