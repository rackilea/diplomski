if (obj instanceof Company) {
    Company company = (Company) obj;
    companies.put(someId, company);
} else if (obj instanceof Person) {
    Person person = (Person) obj;
    persons.put(someId, person);
}