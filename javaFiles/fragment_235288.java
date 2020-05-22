package de.scrum_master.app;

public class RaceCar implements IVehicle {
  @Override
  @Authenticated(Role.Pilot)
  public void start() {
    System.out.println("Starting");
  }

  @Override
  @Authenticated(Role.Pilot)
  public void move() {
    System.out.println("Moving");
  }

  @Override
  @Authenticated(Role.Pilot)
  public void stop() {
    System.out.println("Stopping");
  }
}