boolean isSubsequence(List<?> sup, List<?> sub) {
  Iterator<?> supIt = sup.iterator();
  for (Iterator<?> subIt = sub.iterator(); subIt.hasNext();) {
    Object current = subIt.next();
    boolean found = false;
    while (supIt.hasNext() && !found) {
      found |= supIt.next().equals(current);
    }
    if (!found) {
      return false;
    }
  }
  return true;
}