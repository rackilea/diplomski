public class User {
  private String name;
  public User(String name) {
    this.name = name;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof User))
      return false;
    User user = (User) obj;
    return user.name.equals(this.name);
  }
  @Override
  public int hashCode() {
    return name.hashCode()  ;
  }
}

class UserMain {
  public static void main(String[] args) {
    Set<User> set = new HashSet<>();
    set.add(new User("A"));
    set.add(new User("B"));
    set.add(new User("A"));
    System.out.println(set.size());
  }
}