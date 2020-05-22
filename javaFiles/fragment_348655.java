Person found = null;
for (Person person : listPeople)
{
    if ("Anthares".equals(person.name))
    {
        found = person;
        break;
    }
}
// Check for found == null etc