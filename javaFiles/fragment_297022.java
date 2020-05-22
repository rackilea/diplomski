public class Maps {

  private static Map<String,Members> memberMap=new HashMap<>();

  public static Map<String, Members> getMemberMap() {
        return memberMap;
  }


  public static void setMemberMap(String key,Members object) {
      memberMap.put(key,object);
  }

}