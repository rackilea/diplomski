@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@TypeAlias("Car")
@Document
public class Car {
    @Id
    private String id;
    private String brand;
    private String year;
    private String model;
    private Long horsePower;
    @Version
    private String version;
}