public class Test {
  public static void main(String args[]) {
    new Test().test();
  }
  // Might be better to use a LinkedList here.
  List<Set<String>> groups = new ArrayList<>();

  // Keeps track of what we added and where.
  private static class Added {
    final int where;
    final String what;

    public Added(int where, String what) {
      this.where = where;
      this.what = what;
    }
  }

  // Add if allowed.
  Added add(Set<String> group, int where, String has, String what) {
    if (group.contains(has)) {
      group.add(what);
      return new Added(where, what);
    }
    return null;
  }

  void addPair(String a, String b) {
    // Is ether of the strings in any of the existing groups.
    Added added = null;
    for (int i = 0; added == null && i < groups.size(); i++) {
      Set<String> group = groups.get(i);
      added = add(group, i, a, b);
      if (added == null) {
        added = add(group, i, b, a);
      }
    }
    if (added != null) {
      // Merge any now-joined groups.
      for (int i = added.where + 1; i < groups.size(); i++) {
        Set<String> group = groups.get(i);
        if (group.contains(added.what)) {
          // Join them.
          groups.get(added.where).addAll(group);
          groups.remove(group);
          // There shouldn't be any more.
          break;
        }
      }
    } else {
      // New group - May be better to use a TreeSet here for print order.
      Set<String> group = new HashSet<>();
      group.add(a);
      group.add(b);
      groups.add(group);
    }
  }

  void printGroups(String title) {
    System.out.println(title);
    for (int i = 0; i < groups.size(); i++) {
      System.out.println("Group " + (i + 1) + "=" + groups.get(i));
    }
  }

  public void test() {
    addPair("b", "a");
    addPair("c", "b");
    addPair("c", "a");
    addPair("d", "e");
    printGroups("Test-1");
    addPair("d", "b");
    printGroups("Test-2");
  }
}