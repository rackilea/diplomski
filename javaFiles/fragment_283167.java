public class UserInfo {

  public String getPassportId() {...}

  public Optional<String> passportId() {
    return Optional.ofNullable(passportid);
  }

  ...

if (userInfo.getAge() > 20) {
  userInfo.passportId().ifPresent(...)
}