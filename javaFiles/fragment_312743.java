boolean isSubsequence(List<?> sup, List<?> sub) {
    int current = 0;
    for (Object obj: sup) {
      if (current == sub.size()) {
         return true;
      }
      if (obj.equals(sub.get(current)) {
        current++;
      }
    }
    return current == sub.size();
}