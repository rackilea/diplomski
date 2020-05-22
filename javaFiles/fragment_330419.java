@Entity
@Table(name = "map_holder")
public class MapHolder {
  @Id
  @Column(name = "map_id")
  public Integer mapId;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "map_id")
  @MapKey(name = "recordKey")
  public Map<String, MapRecord> values = new HashMap<>();

  public MapHolder() {

  }

  public MapHolder(Integer mapId) {
    this.mapId = mapId;
  }

  public void put(String key, String value) {
    if(values.containsKey(key)) {
      values.get(key).add(value);
    } else {
      MapRecord mr = new MapRecord();
      mr.mapId = mapId;
      mr.recordKey = key;
      mr.recordValue = value;
      values.put(key, mr);
    }
  }
}