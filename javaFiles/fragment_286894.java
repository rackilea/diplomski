public interface Groupable<G extends Comparable<G>> {
  public G getGroup();
}

public class GroupList<G extends Comparable<G>> {
  private HashMap<G, Groupable<G>[]> data;
  public void add(Groupable<G> e) {
    G group = e.getGroup();
    if(!data.containsKey(group)) { /* make new group for the element */ }
    /* add element to matching group */
  }
  public Groupable<G>[][] get() {
    /* return all the data, with the sets ordered by their Comparable */
  }
}