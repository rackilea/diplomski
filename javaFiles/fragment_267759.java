public int compare(Entity l, Entity r) {
    if (Objects.equals(l, r)) return 0; // Handles normal and null equality
    else if(l == null) return -1; // Enforce null < a ∀ nonnull a
    else if(r == null) return +1; // Enforce a > null ∀ nonnull a
    else return Integer.compare(l.getY(), r.getY()); // Base comparison
}