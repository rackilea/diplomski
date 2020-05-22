public Comparator<Friend> getComparator(final String sortBy) {
  if ("name".equals(sortBy)) {
    return new Comparator<Friend>() {
      @Override int compare(Friend f1, Friend f2) 
        return f1.getName().compareTo(f2.getName());
      }
    };
  } else if ("location".equals(sortBy)) {
    return new Comparator<Friend>() {
      @Override int compare(Friend f1, Friend f2) 
        return f1.getLocation().compareTo(f2.getLocation());
      }
    };
  } else if ("temp".equals(sortBy)) {
    // ...
  } else {
    throw new IllegalArgumentException("invalid sort field '" + sortBy + "'");
  }
}