public interface NameAndDuration {
    String getName();
    Long getDuaration();
}

@Query("select u.name as name, sum(a.minutes) as duration from User u join u.activityStatus st join st.activity a where st.status = "COMPLETED" and u.type = ?1 group by u.name")
List<NameAndDuration> getNameAndDurationByUserType(String userType);

List<NameAndDuration> list = getNameAndDurationByUserType("TEST");
String userName = list.get(0).getName();