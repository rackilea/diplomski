package de.scrum_master.app;

public class RacingApp {
  public static void main(String[] args) {
    IVehicle raceCar = new RaceCar();
    raceCar.start();
    raceCar.move();
    raceCar.stop();
  }
}