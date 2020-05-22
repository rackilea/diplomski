MultimapBuilder.treeKeys(new Comparator<Pair<Double, Double>>() {
      @Override public int compare(Pair<Double, Double> p1, Pair<Double, Double> p2) {
        return ComparisonChain.start()
            .compare(p1.first(), p2.first())
            .compare(p1.second(), p2.second())
            .result();
      }
    }).arrayListValues().build();