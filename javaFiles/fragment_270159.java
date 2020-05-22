@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "cameras")
public class Camera {
    private long id;
    private List<AlarmZone> alarm_zones = new ArrayList<AlarmZone>();

    @SequenceGenerator(name="Camera_Gen", sequenceName="cameras_seq")
    @Id @GeneratedValue(generator="Camera_Gen")    
    public long getId() {
        return this.id;
    }

    @OneToMany(mappedBy="camera") // this maps a bi-directional relationship
    public List<AlarmZone> getAlarmZones() {
        return alarm_zones;
    }

    ...
}

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "zones")
public class Zone {
  // same deal as above
  ...
}

@Entity
@Table(name = "alarmzones")
public class AlarmZone extends Zone {
  private Camera camera;

  @ManyToOne
  public Camera getCamera() {
    return this.camera;
  }
}