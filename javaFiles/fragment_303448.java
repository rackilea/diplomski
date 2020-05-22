interface CarSummary {

  String getName();
  Long getId();
  UserSummary getUser();

  interface UserSummary {
    String getName();
    Long getId();
  }
}