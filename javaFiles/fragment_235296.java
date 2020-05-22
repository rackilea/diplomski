package de.scrum_master.app;

public class AnotherApp {
  public static void main(String[] args) {
    System.out.println("=== Another app ===");
    IVehicle raceCar = new RaceCar();
    raceCar.start();
    raceCar.move();
    raceCar.stop();
  }
}