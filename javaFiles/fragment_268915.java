public class MyVehicle extends Vehicle {
  public MyVehicle(MyVehicleDTO vehicleDto) {
    super(vehicleDto.getVehicleDto());
  }

  @Override
  public double getSpeed() {
    // change the following line to have a dynamic speed
    return dto.getSpeed();
  }

  @Override
  protected void tickImpl(TimeLapse time) {}
}