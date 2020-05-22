Base.open(/*connection params for DB1*/);
List<Person> johns = Person.where("first_name = ?", "John");
Base.close();

Base.open(/*connection params for DB2*/);
for(Person person:johns){
    person.set("first_name", "Bill").setId(null).saveIt();
}
Base.close();