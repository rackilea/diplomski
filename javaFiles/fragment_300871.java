Person person = personRepository.find(personId);
for (Address address : person.getAddresses()) {
  if ("CONTACT_ADDRESS".equals(address.getType()) {
    address.setCity("London");
  }
}