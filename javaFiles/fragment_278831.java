if (list.size() > 0) {
  Collections.sort(list, new Comparator<Campaign>() {
      @Override
      public int compare(final Campaign object1, final Campaign object2) {
          return object1.getName().compareTo(object2.getName());
      }
  });
}