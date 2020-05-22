public class NameCount {
    String name;
    int count;
    public NameCount(Object[] o) {
        name = (String) o[0];
        count = (Integer) o[1];
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
}

 public List<NameCount> getResults() {
    List<Object[]> results = entityManager.createQuery(...);

    List<NameCount> rowset = new ArrayList<NameCount>();
    for (Object[] o : results) {
        rowset.add(new NameCount(o));
    }
    return rowset;
 }