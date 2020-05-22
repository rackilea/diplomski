@Entity
@Table(name = "map_record",
  uniqueConstraints= @UniqueConstraint(columnNames={"map_id", "record_key", "record_value"}))
public class MapRecord {
    @Id
    @Column(name = "record_id", columnDefinition = "INTEGER NOT NULL")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public  Integer recordId;

    @Column(name = "map_id")
    public  Integer mapId;

    @Column(name = "record_key")
    public  String recordKey;

    @Column(name = "record_value")
    public  String recordValue;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "record_key", referencedColumnName = "record_key")
    public List<MapRecord> values = new ArrayList<>();

    public void add(String value) {
        MapRecord mr = new MapRecord();
        mr.mapId = mapId;
        mr.recordKey = recordKey;
        mr.recordValue = value;
        values.add(mr);
    }
}