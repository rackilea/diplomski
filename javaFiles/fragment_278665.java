package de.scrum_master.app;

public class Population {
  private int size;

  public Population() {
    size = 0;
  }

  public void newYear() {
    size += 10;
  }

  public int getSize() {
    return size;
  }

  public static void main(String[] args) {
    Population population1 = new Population();
    population1.newYear();
    population1.newYear();
    Population population2 = new Population();
    population2.newYear();
    population2.newYear();
  }
}