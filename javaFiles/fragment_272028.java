public void addMember(String name, int age, String dOB)
    {
    //Create a new Person instance with given parameters
    Person p = new Person(name,age,dOB);

    //Loop through existing Person instances in ArrayList
    for (Person pers : members){
        //If there exists a Person with the same name
        if (pers.getName().equals(name)) {
            //We can stop searching for a duplicate and leave the method
            return;
        }
    }
    //Since we did not exit the method above we did not found any duplicate, therefore it is safe to add our Person instance to our ArrayList
    members.add(p);
}