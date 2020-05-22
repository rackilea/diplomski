final String special = "oranges";
Collections.sort(
    list,
    new Comparator<String>() {
      public int compare(String left, String right) {
        return ComparisonChain.start()
            .compareTrueFirst(left.equals(special), right.equals(special))
            .compare(left, right)
            .result();
      }
    });