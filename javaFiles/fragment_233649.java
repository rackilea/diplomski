public class UserDetailOrderCountDto {
  private String firstName;
  private String lastName;
  private long orderCount;

  public UserDetail() {
  }

  public UserDetail(String firstName, String lastName, long orderCount) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.orderCount = orderCount;
  }

  // Getters and setters
}