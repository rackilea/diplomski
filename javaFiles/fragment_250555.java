public boolean equals(Object ob) {
  if (ob == null) return false;
  if (ob == this) return true;

  if (!(ob instanceof MyClass)) return false; // OR
  if (ob.getClass() != getClass()) return false;

  // check relevant members
}