@XmlRootElement(name = "pie")
public class Pie {

  @XmlElement(name = "slice")
  public List<Slice> slices = new ArrayList<Slice>();

  public Pie() {
  }

  public Pie(Map<String, String> sliceMap) {
    for (Map.Entry<String, String> entry : sliceMap
        .entrySet()) {
      Slice slice = new Slice();
      slice.title = entry.getKey();
      slice.value = entry.getValue();
      slices.add(slice);
    }
  }

  static class Slice {
    @XmlAttribute
    public String title;
    @XmlValue
    public String value;
  }

}