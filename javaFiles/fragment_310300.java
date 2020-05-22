public class Person {
  public class Key {
    private final String homeTown;
    private final String sex;
    private final String eyeColour;

    public Key(String homeTown, String sex, String eyeColour) { ... }

    public boolean equals(Object o) { /* Override to perform deep equals. */ }
    public int hashCode() { /* Could pre-compute in advance if the key elements never change. */ }
  }

  private final Key key;
  private final String name;
  private final long height;

  public Person(String homeTown, String sex, String eyeColour, String name, long height) {
    this.key = new Key(homeTown, sex, eyeColour);
    this.name = name;
    this.height = height;
  }

  public Key getKey() {
    return key;
  }

  public String getName() { return name; }
  public long getHeight() { return height; }
}