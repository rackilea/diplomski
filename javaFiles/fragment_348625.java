List<String> personIds=new ArrayList<>();
for(Person p: persons){ // Iterate over persons List
  if(p.getPersonId()!=null){ //Check the personId from Person
    personIds.add(p.getPersonId());
  }
}