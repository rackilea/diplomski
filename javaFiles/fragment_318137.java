class ScoreComparator implements Comparator <ObjectHolder> {
    @Override
    public int compare(ObjectHolder o1, ObjectHolder o2) {
      return o1.getScore().compareTo(o2.getScore());
    }
  }

  class DescendingScoreComparator implements Comparator <ObjectHolder> {
    @Override
    public int compare(ObjectHolder o1, ObjectHolder o2) {
      return o2.getScore().compareTo(o1.getScore());
    }
  }


  class ObjectHolder {
    Object obj;
    Integer score;

    public ObjectHolder(Object o, Integer score) {
      this.obj = o;
      this.score = score;
    }

    public Object getObject() {
      return obj;
    }
    public Integer getScore() {
      return score;
    }
  }


  public void showExample() {
    SortedSet<ObjectHolder> sortedSet = new TreeSet<ObjectHolder>(new ScoreComparator());
    sortedSet.add(new ObjectHolder("addedFirst", 55));
    sortedSet.add(new ObjectHolder("addedSecond", 25));
    sortedSet.add(new ObjectHolder("addedThird", 75));
    sortedSet.add(new ObjectHolder("addedFourth", 25));
    sortedSet.add(new ObjectHolder("addedFifth", 95));

    // The resulting set will only have 4 items since sets don't allow duplicates
    for (ObjectHolder holder : sortedSet) {
      System.out.println(holder.getScore());
    }

    List<ObjectHolder> list = new LinkedList<ObjectHolder>();
    list.add(new ObjectHolder("addedFirst", 55));
    list.add(new ObjectHolder("addedSecond", 25));
    list.add(new ObjectHolder("addedThird", 75));
    list.add(new ObjectHolder("addedFourth", 25));
    list.add(new ObjectHolder("addedFifth", 95));

    Collections.sort(list, new ScoreComparator());

    // The resulting set will only have 5 items since lists allow duplicates
    System.out.println();
    for (ObjectHolder holder : list) {
      System.out.println(holder.getScore());
    }

    Collections.sort(list, new DescendingScoreComparator());

    System.out.println("\nWill print 5 items, but this time in descending order");
    for (ObjectHolder holder : list) {
      System.out.println(holder.getScore());
    }
  }