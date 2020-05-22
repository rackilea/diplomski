for (Iterator<Type> it1 = list.iterator(); it1.hasNext();) {
  Type a = it1.next();
  for (Iterator<Type> it2 = a.iterator(); it2.hasNext();) {
      Type b = it2.next();
  }
}