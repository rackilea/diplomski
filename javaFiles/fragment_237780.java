enum TrafficLight {
  RED,
  GREEN;

  @Override
  public String toString() {
    switch(this) {
      case RED: return "abc";
      case GREEN: return "def";
      default: throw new IllegalArgumentException();
    }
  }
}