public class PersonMapper {
   public PersonDTO toDTO(Person p) { // not null
     PersonDTO dto = new PersonDTO();
     dto.setName(p.getName());
     dto.setStates(new ArrayList<>());
     states.forEach(state -> state.getPersons().add(dto)) //todo: uniqueness check
     return dto;
   }
}

public class StateMapper {
   //todo: maybe Person.name is better than the whole Person object in the map
   public StateDTO toDTO(State s, Map<Person, PersonDTO> personMapping) { 
     StateDTO dto = new StateDTO();
     dto.setName(s.getName()); 

     List<PersonDTO> persons = s.getPersons().stream().map(personMapping::get)
                               .collect(Collectors.toList();
     persons.forEach(p -> p.getStates().add(dto)) //todo: uniqueness check for states or use a set
     dto.setPersons(persons);

     return dto;
  }
}