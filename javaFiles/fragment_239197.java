enum EnumDemo{
 A1(0),
 A2(0),
 A3(0),

 B1(1),
 B2(1),
 B3(1),

 C1(2),
 C2(2),
 C3(2);

 private int groupId;

 private EnumDemo(int groupId) {
   this.groupId = groupId;
 }

 public static Set<EnumDemo> getGroup(int groupId) {
    Set<EnumDemo> group = EnumSet.noneOf(EnumDemo.class);
    for (EnumDemo value : values()) {
      if (value.groupId == groupId) {
        group.add(value);
      }
    }
    return group;
 }
}