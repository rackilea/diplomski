public String getPostcode(Person person) {

    if (person == null) return null;
    Address address = person.getAddress();
    return address != null ? address.getPostcode() : null;
}