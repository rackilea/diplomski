public static void main(String[] args) {

   Person usersArray[] = { new Person("RankX", 1), new Person("RankY", 100),
   new Person("RankZ", 44), new Person("RankF", 21) };

   List<Person> users = Arrays.asList(usersArray);
   Collections.sort(users);
   System.out.println(users);

   Collections.sort(users, Collections.reverseOrder());
   System.out.println(users);
}