public class Car {

    @ApiModelProperty(value = "id", required = true)
    long id;

    @ApiModelProperty(value = "wheels", required = true)
    int wheels;

    @ApiModelProperty(value = "name", hidden = true)
    String name;

    @ApiModelProperty(value = "type", hidden = true)
    String type;

    @ApiModelProperty(value = "canFly", hidden = true)
    boolean canFly;
}