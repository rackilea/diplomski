List<PersonDTO> persons = new ArrayList<>();
while(rs.next())
        String name = rs.getString("name");
        PersonDTO personDTO = new PersonDTO(); // Or use some injected factory
        personDTO.setName(name);
        persons.add(personDTO);
}