//Declare with List instead of ArrayList
List<Person> people = new ArrayList<Person>();

for(i = 0; i< 3; i++){
  Person p = new Person();// Move this line here.
  p.setName("Jon"); // Read attribute from file
  p.setAge(33);
  people.add(p);//Index should not mentioned
  ....
}