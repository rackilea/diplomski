class AndKey {
  private final ImmutableList<Character> symbols;

  AndKey(Character... symbols) { this.symbols = ImmutableList.copyOf(symbols); }

  @Override int hashCode() { return symbols.hashCode(); }
  @Override boolean equals(Object obj) {
    if (obj == this) { return true; }
    if (obj instanceof AndKey) { return symbols.equals(((AndKey) obj).symbols); }
    return false;
}