for(int i = 0; i < peopleContainer.length; i++)
{
    Person person = allPeople.get(i);
    fullName = person.getFirstName() + " " + person.getLastName();  
    peopleContainer[i] = fullName;  
}