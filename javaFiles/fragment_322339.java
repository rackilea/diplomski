class YourClass {
   public static Set<String> studentSet = new HashSet<>();

   public static void addStudent(String name, String gender) {
     YourClass.studentSet.add(name + "," + gender);
   }

   public static Boolean studentExists(String name, String gender) {
     return YourClass.studentSet.constains(name + "," + gender);
}