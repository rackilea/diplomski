@Entity
    @Table(name = "device_settings")
    public class DeviceSettings {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "device_settings_id")
        private Long id;


        @OneToMany( mappedBy = "deviceSettings", cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
         private List<Device> devices;
}