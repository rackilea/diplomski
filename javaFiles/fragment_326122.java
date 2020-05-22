@Entity
@Table(name = "device")
public class Device {

        @EmbeddedId
        private DeviceKey deviceKey;

        @ManyToOne
        @JoinColumn(name="device_settings_id")
        private DeviceSettings deviceSettings;
       //getters and setters
}