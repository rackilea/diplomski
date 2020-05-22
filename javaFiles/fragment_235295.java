package de.scrum_master.app;

public class RacingApp {
  public static void main(String[] args) {
    System.out.println("=== Racing app ===");
    IVehicle raceCar = new RaceCar();
    raceCar.start();
    raceCar.move();
    raceCar.stop();
    AnotherApp.main(args);
  }
}