hashCode = 1;
  Iterator i = list.iterator();
  while (i.hasNext()) {
      Object obj = i.next();
      hashCode = 31*hashCode + (obj==null ? 0 : obj.hashCode());
  }