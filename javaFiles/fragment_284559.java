static void sort(List<String> words) {
    Collections.sort(words, new Comparator<String>() {

      @Override
      public int compare(String lhs, String rhs) {
        return Constants.CHAMORRO_COLLATOR.compare(lhs, rhs);
      }

    });
  }