public Direction getNativeDirection() {
  if (this == NaturalDirection.NASC)
    return Direction.ASC;
  if (this == NaturalDirection.NDESC)
    return Direction.DESC;
  return Direction.fromString(String.valueOf(this));
}