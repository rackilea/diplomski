@Entity

public class Airplane implements Serializable {
...
    @JsonIgnore
    @OneToOne(mappedBy = "airplaneDetail")
    private Flight flight;
...
}