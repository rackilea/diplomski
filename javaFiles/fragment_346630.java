@JsonDeserialize(using = BaseVehicleJsonDeserializer.class)
abstract class BaseVehicle {

    @JsonProperty
    private String make;

    @JsonProperty
    private String model;

}

@JsonDeserialize(as = Car.class)
final class Car
        extends BaseVehicle {
}

@JsonDeserialize(as = Motorcycle.class)
final class Motorcycle
        extends BaseVehicle {

    @JsonProperty
    private int numCylinders;

}