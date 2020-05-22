this.referenceService.get(id)
    .map(this::toHashString);

private Strign toHashString(Reference ref) {
  return Integer.toString(ref.hashCode());
}