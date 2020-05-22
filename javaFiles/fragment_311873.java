import java.util.*;

public class GroupBy {

  public static void main(String[] args) {
    List<UserType> userTypes = new ArrayList<>();
    userTypes.add(new UserType(1, 101, "ASSEMBLE"));
    userTypes.add(new UserType(1, 102, "ASSEMBLE"));
    userTypes.add(new UserType(2, 103, "ARCHS"));
    userTypes.add(new UserType(3, 103, "ARCHS"));
    userTypes.add(new UserType(4, 104, "BAYLEAF"));
    userTypes.add(new UserType(4, 105, "BAYLEAF"));
    userTypes.add(new UserType(5, 106, "CHARSET"));

    Map<String, UserTypeGroup> map = new HashMap<>();
    for (UserType u : userTypes) {
      if (!map.containsKey(u.getUserType())) {
        map.put(u.getUserType(), new UserTypeGroup(u.getUserType()));
      }
      map.get(u.getUserType()).getUserIds().add(u.getUserId());
      map.get(u.getUserType()).getUserTypeIds().add(u.getUserTypeId());
    }

    System.out.println("INPUT:");
    System.out.println(userTypes);

    System.out.println("\nOUTPUT:");
    System.out.println(map.values());
  }
}

class UserType {

  private int userId;
  private int userTypeId;
  private String userType;

  UserType(int userId, int userTypeId, String userType) {
    this.userId = userId;
    this.userTypeId = userTypeId;
    this.userType = userType;
  }

  int getUserId() {
    return userId;
  }

  int getUserTypeId() {
    return userTypeId;
  }

  String getUserType() {
    return userType;
  }

  @Override
  public String toString()
  {
    return "{userId: " + userId + ", userTypeId: " + userTypeId +", userType: " + userType + "}\n";
  }
}

class UserTypeGroup {

  private String userType;
  private Set<Integer> userIds = new HashSet<>();
  private Set<Integer> userTypeIds = new HashSet<>();

  UserTypeGroup(String userType) {
    this.userType = userType;
  }

  Set<Integer> getUserIds() {
    return userIds;
  }

  Set<Integer> getUserTypeIds() {
    return userTypeIds;
  }

  @Override
  public String toString()
  {
    return "{userIds: " + userIds + ", userTypeIds: " + userTypeIds + ", userType: " + userType + "}\n";
  }
}