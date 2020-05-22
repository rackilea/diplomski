HashSet<List<Integer>> set = new HashSet<List<Integer>>() {
  @Override
  public String toString() {
    if (size() == 0) {
        return "";
    }

    StringBuilder sb = new StringBuilder();
    Iterator<List<Integer>> it = iterator();
    sb.append('[');
    for (;;) {
        it.next();
        sb.append("some random text");

        if (!it.hasNext()) {
          return sb.append(']').toString();
        }
        sb.append(',').append(' ');
    }
  }
};